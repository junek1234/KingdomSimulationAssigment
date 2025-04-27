package orange;

public class GoldNugget implements Gem
{
  private final int value=2;
  @Override public String getName()
  {
    return "GoldNugget";
  }

  @Override public int getValue()
  {
    return value;
  }
}
