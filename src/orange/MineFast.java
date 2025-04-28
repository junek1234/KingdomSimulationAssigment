package orange;

import java.util.Random;

public class MineFast implements MineStrategy
{
  private Random rand = new Random();
  @Override public Gem mine()
  {
    String[] keys= {"GoldNugget","WoodenCoin","Ruby"};
    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    return GemMine.getInstance(keys[rand.nextInt(3)]);
  }
}
