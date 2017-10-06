import junit.framework.TestCase;

public class LineTest extends TestCase {
  
  public void testtoString(){
    Point p1 = new Point(4.1,4.1,4.1);
    Vector v = new Vector(4.1,4.1,4.1);
    Line l = new Line(p1, v);
    assertEquals(l.toString(), "(4.1x+4.1,4.1y+4.1,4.1z+4.1)");
  }
  
   public void testequals() {
    Point p1 = new Point(0,0,0);
    Point p2 = new Point(0,3,0);
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    Line l1 = new Line(p1, v1);
    Line l2 = new Line(p1, v2);
    assertFalse("two different lines", l1.equals(l2));
    
    Line l3 = new Line(p2, v1);
    assertFalse("line with different starting points but same slope", l1.equals(l3));
    
    assertEquals("not even a line", false, l1.equals(v2));
    
    Line l4 = new Line(p1,v1);
    assertEquals("Same line", true, l1.equals(l1));
  }


  
  public void testisOnLine(){
    Point p1 = new Point(0,0,0);
    Point p2 = new Point(0,3,0);
    Vector v1 = new Vector(3,4,5);
    Line l1 = new Line(p1, v1);
    assertEquals("On the line", true, l1.isOnLine(p1));
    assertEquals("Not on the line", false, l1.isOnLine(p2));
  }
  
  public void testisParallel(){
    Point p1 = new Point(0,0,0);
    Point p2 = new Point(0,3,0);
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    Line l1 = new Line(p1, v1);
    Line l2 = new Line(p1, v2);
    assertEquals("Not Parallel", false, ((l1.getVector()).unitVector() == (l2.getVector()).unitVector()));
    
    Vector v3 = new Vector(6,8,10);
    Line l3 = new Line(p2, v3);
    assertEquals("Parallel", false, ((l1.getVector()).unitVector() == (l3.getVector()).unitVector()));
  }
  
  public void testintersection(){
    
    Point p1 = new Point(0,0,0);
    Point p2 = new Point(0,3,0);
    Vector v1 = new Vector(2,2,2);
    Vector v2 = new Vector(4,4,4);
    Line l1 = new Line(p1, v1);
    Line l2 = new Line(p1, v2);
    assertEquals("No Intersection", null, Line.intersection(l1,l2));
    
    Vector v3 = new Vector(1,3,2);
    Line l3 = new Line(p1, v3);
    assertEquals("intersection point", new Point(0.0,0.0,0.0), Line.intersection(l1, l3));
    
  }
}