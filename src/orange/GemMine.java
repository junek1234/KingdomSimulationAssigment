package orange;

import java.util.HashMap;
import java.util.Map;

public class GemMine {
  private static Map<String, Gem> allInstances = new HashMap<>();

  public static Gem getInstance(String key) {
    Gem instance = allInstances.get(key);
    if (instance == null)
    {
      instance = createGem(key);
    }
    return instance;
  }

  private static Gem createGem(String key) {
    switch (key) {
      case "Diamond" ->
      {
        return new Diamond();
      }
      case "Cow" ->
      {
        return new Cow();
      }
      case "GoldNugget" ->
      {
        return new GoldNugget();
      }
      case "Jewel" ->
      {
        return new Jewel();
      }
      case "Ruby" ->
      {
        return new Ruby();
      }
      case "WoodenCoin" ->
      {
        return new WoodenCoin();
      }
      default ->
      {
        return null;
      }
    }
  }
}
