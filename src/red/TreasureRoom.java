package red;

import green.Catalogue;
import orange.Gem;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
  private List<Gem> gems;

  public TreasureRoom() {
    gems = new ArrayList<>();
  }

  // access methods

  public synchronized void acquireReadAccess(String actorName) {
    Catalogue.getInstance().add(actorName+" entered the Treasure Room");
  }

  public synchronized void acquireWriteAccess(String actorName) {
    Catalogue.getInstance().add(actorName+" entered the Treasure Room");
  }

  public synchronized void releaseReadAccess(String actorName) {
    Catalogue.getInstance().add(actorName+" left the Treasure Room");
  }

  public synchronized void releaseWriteAccess(String actorName) {
    Catalogue.getInstance().add(actorName+" left the Treasure Room");
  }

  // interact methods

  public Gem retrieveValuable() {
    Gem v = null;
    if (gems.size() > 0) {
      v = gems.remove(0);
    }
    return v;
  }

  public void addValuable(Gem v) {
    gems.add(v);
  }

  @Override
  public List<Gem> lookAtAllGems() {
    return new ArrayList<Gem>(gems);
  }
}