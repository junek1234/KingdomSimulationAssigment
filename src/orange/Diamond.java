package orange;

public class Diamond implements Gem
{
  private final int value=5;
  @Override public String getName()
  {
    return "Diamond";
  }

  @Override public int getValue()
  {
    return value;
  }
}
