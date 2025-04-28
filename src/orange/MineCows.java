package orange;

public class MineCows implements MineStrategy
{
  @Override public Gem mine()
  {
    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    return GemMine.getInstance("Cow");
  }
}
