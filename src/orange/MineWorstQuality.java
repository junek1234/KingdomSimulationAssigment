package orange;

public class MineWorstQuality implements MineStrategy
{

  @Override public Gem mine()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    return GemMine.getInstance("WoodenCoin");
  }
}
