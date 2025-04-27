package orange;

public class Cow implements Gem
{
  private final int value=3;
  @Override public String getName()
  {
    return "Cow";
  }

  @Override public int getValue()
  {
    return value;
  }
}
