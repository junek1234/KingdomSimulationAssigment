package orange;

import green.Catalogue;

public class GemMineWorker implements Runnable
{
  private GemMine gemMine;
  private GemDepositInterface gemDeposit;
  private MineStrategy mineStrategy;
  private Catalogue catalogue;
  private String name;
  public GemMineWorker(GemMine gemMine, GemDepositInterface gemDeposit, String name)
  {
    this.gemMine=gemMine;
    this.gemDeposit=gemDeposit;
    mineStrategy=new MineFast();
    catalogue=Catalogue.getInstance();
    this.name=name;
  }
  @Override public void run()
  {
    Gem gem;
    while(true)
    {
       gem = mineStrategy.mine();
       catalogue.add(gem.getName()+" was mined by worker "+name);
       gemDeposit.put(gem);
    }
  }
  public void changeMineStrategy(String strategyName)
  {
    switch(strategyName)
    {
      case "MineFast" -> mineStrategy=new MineFast();
      case "MineSlow" -> mineStrategy=new MineSlow();
      case "MineCows" -> mineStrategy=new MineCows();
      case "MineBestQuality" -> mineStrategy=new MineBestQuality();
      case "MineWorstQuality" -> mineStrategy=new MineWorstQuality();
    }
  }
}
