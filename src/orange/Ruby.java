package orange;

public class Ruby implements Gem
{
  private final int value=4;
  @Override public String getName()
  {
    return "Ruby";
  }

  @Override public int getValue()
  {
    return value;
  }
}
