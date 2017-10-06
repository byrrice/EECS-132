import junit.framework.TestCase;

public class Point2DTest extends TestCase {
  
  public void testtoString(){
    Point p1 = new Point2D(4.1,4.1);
    assertEquals("Shows 2d point as string", p1.toString(), "(4.1,4.1)");
  }
}
