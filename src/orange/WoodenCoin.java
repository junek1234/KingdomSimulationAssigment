package orange;

public class WoodenCoin implements Gem
{
  private final int value=1;
  @Override public String getName()
  {
    return "WoodenCoin";
  }

  @Override public int getValue()
  {
    return value;
  }
}
