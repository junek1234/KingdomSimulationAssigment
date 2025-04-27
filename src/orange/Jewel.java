package orange;

public class Jewel implements Gem
{
  private final int value=3;
  @Override public String getName()
  {
    return "Jewel";
  }

  @Override public int getValue()
  {
    return value;
  }
}
