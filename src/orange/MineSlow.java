package orange;

import java.util.Random;

public class MineSlow implements MineStrategy
{

  private Random rand = new Random();
  @Override public Gem mine()
  {
    String[] keys= {"Diamond","Jewel","Ruby","GoldNugget"};
    try
    {
      Thread.sleep(5000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    return GemMine.getInstance(keys[rand.nextInt(4)]);
  }
}
