import junit.framework.TestCase;

public class Line2DTest extends TestCase {
  
  public void testtoString(){
    Point2D p1 = new Point2D(2,2);
    Point2D p2 = new Point2D(2,3);
    Line2D l1 = new Line2D(p1, p2);
    assertEquals("x=2.0", l1.toString());
    
    Point2D p3 = new Point2D(1,1);
    Line2D l2 = new Line2D(p1, p3);
    assertEquals("y=1.0x+0.0",l2.toString());
  }
  
  public void testintersection() {
    Point2D p1 = new Point2D(2,3);
    Point2D p2 = new Point2D(1,-1);
    Point2D p3 = new Point2D(2,2);
    Line2D l1 = new Line2D(p1, p2);
    Line2D l2 = new Line2D(p2, p3);
    assertEquals("Tests for intersection", new Point2D(1.0,-1.0), Line2D.intersection(l1, l2));
    
    Point2D p5 = new Point2D(2,2);
    Point2D p6 = new Point2D(2,3);
    Line2D l3 = new Line2D(p5, p6);
    Point2D p4 = new Point2D(2,4);
    Line2D l4 = new Line2D(p5, p4);
    assertEquals("Parallel", null, Line2D.intersection(l4,l31));
  }
  
}