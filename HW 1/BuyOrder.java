//Isaac Ng, This class extends Order and represents the buyer
public class BuyOrder extends Order{
public BuyOrder(char a, int b, double c, boolean e, Trader trader) {
    super(a, b, c, e, trader);
  }
}

/*> BuyOrder b = new BuyOrder('a', 20, 2.5, true, new Trader("hi"))
> b.getTrader().getName()
"hi" */