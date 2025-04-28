package orange;

public interface GemDepositInterface
{
  void put(Gem element);
  Gem take();
  boolean isEmpty();
  boolean isFull();
  int size();
}
