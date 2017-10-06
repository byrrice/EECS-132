//Isaac Ng, This class has all the data associated with buying and selling stocks
public class Order {

  //Stores symbol for stock
  private char symbol = '*';
    
  //Stores number of shares
  private int numbershares = 100;
    
  //Stores price of share
  private double price;
  
  //Stores true or false based on whether we sell all of stock or not
  private boolean order;
  
  //Stores the trader
  private Trader trader;
  
  //constructor
  public Order(char a, int b, double c, boolean e, Trader trader) {
    this.symbol = a;
    this.numbershares = b;
    this.price = c;
    this.order = e;
    this.trader = trader;
  }
  
  //This method returns the symbol of the stock
  public char getStockSymbol(){
   return symbol; 
  }
  
  //This method gives you the order (number of shares)
  public int getNumberShares(){
    return numbershares;
  }
  
  //This method sets the number of shares the consumer wants
  public void setNumberShares(int x){
    this.numbershares = x;
  }
  
  //This method gets the desired price per share
  public double getPrice(){
    return price;
  }
  
  //This method sets the price per share 
  public void setPrice(double y){
    this.price = y;
  }
  
  //This method determines if we will trade all of the stock(true) or only some(false)
  public boolean getAllOrNone(){
    return order; 
  }
  
  //This method sets whether we do trade all the stocks(true) or not(false)
  public void setAllOrNone(boolean z){
    this.order = z;
  }
  
  //returns the trader who placed the order
  public Trader getTrader(){
    return trader;
  }
}