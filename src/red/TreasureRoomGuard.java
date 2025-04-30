package red;

import green.Catalogue;
import orange.Gem;

import java.util.List;

public class TreasureRoomGuard implements TreasureRoomDoor
{
  private TreasureRoom treasureRoom;
  private int readers, writers, waitingWriters;
  public TreasureRoomGuard(TreasureRoom treasureRoom)
  {
    this.treasureRoom=treasureRoom;
  }
  @Override public synchronized void acquireReadAccess(String actorName)
  {
    Catalogue.getInstance().add("\u001B[33m"+actorName+" is waiting to enter the Treasure Room"+"\u001B[0m");
    while(writers>0||waitingWriters>0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    readers++;
    treasureRoom.acquireReadAccess(actorName);
  }

  @Override public synchronized void acquireWriteAccess(String actorName)
  {
    Catalogue.getInstance().add("\u001B[33m"+actorName+" is waiting to enter the Treasure Room"+"\u001B[0m");
    waitingWriters++;
    while(readers>0||writers>0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    waitingWriters--;
    writers++;
    treasureRoom.acquireWriteAccess(actorName);

  }

  @Override public synchronized void releaseReadAccess(String actorName)
  {
    readers--;
    treasureRoom.releaseReadAccess(actorName);
    notifyAll();
  }

  @Override public synchronized void releaseWriteAccess(String actorName)
  {
    writers--;
    treasureRoom.releaseWriteAccess(actorName);
    notifyAll();
  }

  @Override public synchronized Gem retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public synchronized void addValuable(Gem v)
  {
    treasureRoom.addValuable(v);
  }

  @Override public synchronized List<Gem> lookAtAllGems()
  {
    return treasureRoom.lookAtAllGems();
  }
}
