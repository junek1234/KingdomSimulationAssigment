import orange.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhiteBoxTestForBranchingMethod {

  @Test
  public void testCreateGem_Diamond() {
    Gem gem = GemMine.createGem("Diamond");
    assertTrue(gem instanceof Diamond);
  }

  @Test
  public void testCreateGem_Cow() {
    Gem gem = GemMine.createGem("Cow");
    assertTrue(gem instanceof Cow);
  }

  @Test
  public void testCreateGem_GoldNugget() {
    Gem gem = GemMine.createGem("GoldNugget");
    assertTrue(gem instanceof GoldNugget);
  }

  @Test
  public void testCreateGem_Jewel() {
    Gem gem = GemMine.createGem("Jewel");
    assertTrue(gem instanceof Jewel);
  }

  @Test
  public void testCreateGem_Ruby() {
    Gem gem = GemMine.createGem("Ruby");
    assertTrue(gem instanceof Ruby);
  }

  @Test
  public void testCreateGem_WoodenCoin() {
    Gem gem = GemMine.createGem("WoodenCoin");
    assertTrue(gem instanceof WoodenCoin);
  }

  @Test
  public void testCreateGem_UnknownKey_returnsNull() {
    Gem gem = GemMine.createGem("Stone");
    assertNull(gem);
  }
}
