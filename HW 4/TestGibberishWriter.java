import junit.framework.TestCase;

public class TestGibberishWriter extends TestCase{
  
  public void testAddFollowingWord(){
    
  }
  
  public void testGetFollowingWord(){
    
  }
  
  public void testAddDatafile(){
  }
  
  public void testcompareTo(){
  }
  
  public void testequals(){
  }
  
  public void testAddContextData(){
    Context context1 = new Context(new String[]{"C"});
    Context context2 = new Context(new String[]{"B"});
    Context context3 = new Context(new String[]{"A"});
    ContextData context1Data = new ContextData(context1);
    ContextData context2Data = new ContextData(context2);
    ContextData context3Data = new ContextData(context3);
    LinkedList<ContextData> LL = new LinkedList<ContextData>();
    LL.addToFront(context1Data);
    LLIterator<ContextData> llIterator = LL.iterator();
    llIterator.addAfter(context3Data);
    
  }
  
  
}
