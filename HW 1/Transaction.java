//Isaac Ng, this class keeps track of the various transactions
public class Transaction {
  
  //Stores stock symbol
  private char symbol;
    
  //stores number of stocks
  private int numshares;
    
  //stores the price of the individual stock
  private double price;
    
  //stores trader buying stock
  private Trader trader1;
    
  //stores trader buying stock
  private Trader trader2;
    
  //stores market handling the transaction
  private Market market;
    
  //stores indicator of transaction going through or not
  private boolean indicator;
   
  //constructor
  public Transaction(char a, int b, double c, Trader d, Trader e, Market market) {
  this.symbol = a;
  this.numshares = b;
  this.price = c;
  this.trader1 = d;
  this.trader2 = e;
  this.market = market;
  }
  
  //This method gives the symbol of the stock
  public char getStockSymbol(){
   return symbol;
  }
  
  //This method returns the number of shares in the transaction
  public int getNumberShares(){
    return numshares;
  }
  
  //This method gets the price
  public double getPrice(){
    return price;
  }
  
  //This method gets the buyer of the stock
  public Trader getBuyer(){
    return trader1;
  }
  
  //This method gets the trader who sells the stock
  public Trader getSeller(){
    return trader2;
  }
  
  //This method returns a boolean value determining whether closed or not
  public boolean isClosed(){
    return indicator;
  }
  
  //This method determines the comission and fees if the transaction closes. 
  public void processTransaction(){
    if (this.indicator == false){ 
      double cost = getNumberShares() * getPrice(); //cost of stocks bought
      getBuyer().withdraw(cost);
      getSeller().deposit(cost);
      double commision = (market.getCommision() * cost) / 2; //comission to be paid
      double fee = (market.getTradeFee()); //transaction fee
      getBuyer().withdraw(fee);
      getSeller().withdraw(fee);
      getBuyer().withdraw(commision);
      getSeller().withdraw(commision);
      market.deposit((commision * 2) + fee);
      indicator = true;
    }
  }
}
      