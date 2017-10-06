import junit.framework.TestCase;

public class PointTest extends TestCase {
  
  public void testtoString(){
    Point p1 = new Point(4.1,4.1,4.1);
    assertEquals(p1.toString(), "(4.1,4.1,4.1)");
  }
  
  public void testequals() {
    Point p1 = new Point(0,0,0);
    Point p2 = new Point(1, 1, 1);
    Vector v = new Vector(1, 1, 1);
    assertFalse("two different points", p1.equals(p2));
    assertFalse("not a point", p1.equals(v));
    p2 = new Point(0,0,0);
    assertEquals("Same points", p1, p2);
  }
  
  public void testaddVector(){
    Vector v = new Vector(5.0, 6.0, 7.0);
    Point p1 = new Point(1.0, 1.0, 1.0);
    Point p2 = new Point(v.vgetX() + p1.getX(), v.vgetY() + p1.getY(), v.vgetZ() + p1.getZ());
    Point p3 = new Point(6.0, 7.0, 8.0);
    assertEquals("Added Point equal to expected result", p2, p3);
  }

  public void testdistance(){
    Point point1 = new Point(1.0, 1.0, 1.0);
    Point point2 = new Point(2.0, 2.0, 2.0);
    double distance = Math.sqrt((point1.getX() - point2.getX() * point1.getX() - point2.getX()) + (point1.getX() - point2.getY() * point1.getX() - point2.getY()));
    assertEquals("Same distance", distance, Point.distance(point1, point2));
  }
}
