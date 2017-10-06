//Isaac Ng, This class extends SellOrder and represents an order to sell stock to a market maker
public class MarketSellOrder extends SellOrder{
  
  //constructor
  public MarketSellOrder(char a, int b, double c, boolean e, Market market) {
  super(a, b, c, false, market);
  }
    
  //method to set it to false always
  public void setAllOrNone(boolean e){}
}