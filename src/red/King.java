package red;

import green.Catalogue;
import orange.Gem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King implements Runnable
{
  private List<Gem> gems;
  private int totalValue;
  private Random rand;
  private TreasureRoomDoor treasureRoom;
  private String name;
  private int costOfTheParty;
  private boolean enoughGemsFlag;
  public King(TreasureRoomGuard treasureRoom, String name)
  {
    this.treasureRoom=treasureRoom;
    this.name=name;
    rand=new Random();
    totalValue=0;
    enoughGemsFlag=true;
    gems = new ArrayList<>();
  }
  @Override public void run()
  {
    while(true)
    {
      enoughGemsFlag=true;
      costOfTheParty= rand.nextInt(151)+50;
      treasureRoom.acquireWriteAccess(name);
      while(totalValue<costOfTheParty)
      {

          try
          {
            Thread.sleep(50);
          }
          catch (InterruptedException e)
          {
            throw new RuntimeException(e);
          }
          Gem gem = treasureRoom.retrieveValuable();
          if(gem==null)//it means there were not enough value of gems cause the while loop was still running so then im going break the loop and put the gems back again
          {
            for (int i = 0; i < gems.size(); i++) {
              try
              {
                Thread.sleep(50);
              }
              catch (InterruptedException e)
              {
                throw new RuntimeException(e);
              }
              treasureRoom.addValuable(gems.get(i));
            }
            enoughGemsFlag=false;
            break;
          }
          else {

          }
          gems.add(gem);
          totalValue+=gem.getValue();

      }

      treasureRoom.releaseWriteAccess(name);
      if(enoughGemsFlag)
      {
        holdAParty();
      }
      else
      {
        cancelParty();
      }


    }

  }

  public void holdAParty()
  {
    gems.clear();
    Catalogue.getInstance().add("\u001B[31m"+"The King is holding a party of a value: "+totalValue+"\u001B[0m");
    totalValue=0;
    try
    {
      Thread.sleep(10000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }

  }
  public void cancelParty()
  {
    gems.clear();
    Catalogue.getInstance().add("\u001B[31m"+"The King cancelled the party, value: "+totalValue+"/"+costOfTheParty+"\u001B[0m");
    totalValue=0;
  }
}
