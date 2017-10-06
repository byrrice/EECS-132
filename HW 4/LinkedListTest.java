import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class LinkedListTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testaddBefore() {
    LinkedList<String> l = new LinkedList<String>();
    l.addToFront("c");
    l.addToEnd("d");
    LLIterator<String> d = l.iterator();
    d.next();
    d.next();
    d.addBefore("e");
    LinkedList<String> expected = new LinkedList<String>();
    expected.addToFront("e");
    expected.addToFront("d");
    expected.addToFront("c");
    assertEquals("Are the same", expected.toString(), l.toString()); 
  }
  
  public void testaddAfter(){
  LinkedList<String> l = new LinkedList<String>();
    l.addToFront("c");
    l.addToEnd("d");
    LLIterator<String> d = l.iterator();
    d.next();
    d.next();
    d.addAfter("e");
    LinkedList<String> expected = new LinkedList<String>();
    expected.addToFront("e");
    expected.addToFront("d");
    expected.addToFront("c");
    assertEquals("Are the same", expected.toString(), l.toString()); 
  }
  
}
