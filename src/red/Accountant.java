package red;

import green.Catalogue;
import orange.Gem;

import java.util.List;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoom;
  private int totalWorthOfGems;
  private String name;

  public Accountant(TreasureRoomGuard treasureRoom, String name)
  {
    this.treasureRoom=treasureRoom;
    this.name=name;
    totalWorthOfGems=0;
  }

  @Override public void run()
  {
    List<Gem> gems;
    while(true)
    {
      treasureRoom.acquireReadAccess(name);
      gems=treasureRoom.lookAtAllGems();

      for (int i = 0; i < gems.size(); i++)
      {
        try
        {
          Thread.sleep(50);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
        totalWorthOfGems+=gems.get(i).getValue();
      }
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      Catalogue.getInstance().add("\u001B[34m"+"Total worth of gems in the Treasure Room: "+totalWorthOfGems+" Counted by "+name+"\u001B[0m");
      treasureRoom.releaseReadAccess(name);
      totalWorthOfGems=0;
    }
  }
}
