package orange;

public class MineBestQuality implements MineStrategy
{

  @Override public Gem mine()
  {
    try
    {
      Thread.sleep(7000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    return GemMine.getInstance("Diamond");
  }
}
