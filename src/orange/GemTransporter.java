package orange;

import green.Catalogue;
import red.TreasureRoomDoor;
import red.TreasureRoomGuard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GemTransporter implements Runnable
{
  private GemDeposit gemDeposit;

  private Random rand = new Random();
  private int targetNumber;
  private int totalGemValue;
  private Catalogue catalogue;
  private String name;
  private TreasureRoomDoor treasureRoom;
  private List<Gem> gems;

  public GemTransporter(GemDeposit gemDeposit, String name, TreasureRoomGuard treasureRoom)
  {
    this.gemDeposit=gemDeposit;
    catalogue = Catalogue.getInstance();
    this.name=name;
    this.treasureRoom=treasureRoom;
    gems = new ArrayList<>();
  }


  @Override public void run()
  {
    while(true)
    {
      targetNumber = rand.nextInt(151) + 50;

      while (totalGemValue < targetNumber)
      {
        Gem gem = gemDeposit.take();
        gems.add(gem);
        totalGemValue += gem.getValue();
        catalogue.add(gem.getName()+" was added to the transporter "+name+" Total transporter value: "+totalGemValue);
      }
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      treasureRoom.acquireWriteAccess(name);
      while(gems.size()>0)
      {
        treasureRoom.addValuable(gems.getFirst());
        gems.removeFirst();
      }
      totalGemValue = 0;
      treasureRoom.releaseWriteAccess(name);
    }

  }
}
