// Isaac Ng, This class trades stocks.
public class Trader {
  
  //The name of the Trader
  private String name;
  
  //The balance of the account
  private double balance = 1299;
  
  //constructor
  public Trader(String name) {
    this.name = name;
  }
  
  //This method will give you the name of the trader. 
  public String getName(){
    return name;
  }
  
  //This method sets the name of the trader;
  public void setName(String newname){
    this.name = newname;
  }
  
  //This method gives you the balance of the trader
  public double getBalance(){
    return balance;
  }
  
  //This method subtracts the amount of money you decide to withdraw from the balance
  public void withdraw(double x){
    balance = balance - x;
  }
  
  //This method adds the amount of money you decide to deposit
  public void deposit(double x){
    balance = balance + x;
  }
}       

/*> Trader t = new Trader("John")
> t.getName()
"John"
> t.setName("Isaac")
> t.getName()
"Isaac"
> t.getBalance()
1299.0
> t.withdraw(1200)
> t.getBalance()
99.0
> t.deposit(100)
> t.getBalance()
199.0
*/
  
  
  