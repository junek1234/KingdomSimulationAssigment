package orange;

public class GemDeposit implements GemDepositInterface
{

  private ListADT<Gem> queue;
  public GemDeposit()
  {
    this.queue= new MyArrayList<>();
  }
  @Override public synchronized void put(Gem element)
  {
    queue.add(element);
    notifyAll();
  }

  @Override public synchronized Gem take()
  {
    while(isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    Gem gem = queue.get(0);
    queue.remove(0);
    return gem;
  }

  @Override public boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public boolean isFull()
  {
    return queue.isFull();
  }

  @Override public int size()
  {
    return queue.size();
  }
}
