//Isaac Ng, This class extends BuyOrder and represents an order to buy stock from a market maker
public class MarketBuyOrder extends BuyOrder{
  
  //constructor
  public MarketBuyOrder(char a, int b, double c, boolean e, Market market) {
  super(a, b, c, false, market);
  }
  
  //method to set it to false always
  public void setAllOrNone(boolean e){}
}