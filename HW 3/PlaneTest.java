import junit.framework.TestCase;

public class PlaneTest extends TestCase {
  
  public void testtoString(){
    Vector v = new Vector(2,4,5);
    Point p = new Point(1,1,1);
    Plane plane1 = new Plane(p, v);
    assertEquals("Testing the plane to string", plane1.toString(), "2.0x + 4.0y + 5.0z + -11.0 = 0");
  }
  
  public void testequals(){
    Vector v1 = new Vector(2,4,5);
    Point p1 = new Point(1,1,1);
    Plane plane1 = new Plane(p1, v1);
    Vector v2 = new Vector(5,6,7);
    Point p2 = new Point(1,2,3);
    Plane plane2 = new Plane(p2, v2);
    boolean marker1 = plane1.getd() == plane2.getd() && Vector.isParallel(plane1.getNormal(), plane2.getNormal());
    assertEquals("Different planes", marker1, plane1.equals(plane2));
    
    
    Plane plane3 = new Plane(p1, v1);
    boolean marker2 = plane3.getd() == plane1.getd() && Vector.isParallel(plane3.getNormal(), plane1.getNormal());
    assertEquals("Same Plane", marker2, plane3.equals(plane1));
    
    Vector v3 = new Vector(2,4,5);
    Point p3 = new Point(3,5,6);
    Plane plane4 = new Plane(p3, v3);
    boolean marker3 = plane4.getd() == plane1.getd() && Vector.isParallel(plane4.getNormal(), plane1.getNormal());
    assertEquals("Same Plane, different starting points", marker3, plane4.equals(plane1));
    
    assertEquals("not even a plane, it is superman", marker1, plane1.equals(p1));
  }
  
  public void testcontains(){
    Vector v1 = new Vector(2,4,5);
    Point dpoint = new Point(1,1,1);
    Point point1 = new Point(3,5,6);
    Plane plane1 = new Plane(dpoint, v1);
    boolean marker1 = ((plane1.geta()*dpoint.getX()+plane1.getb()*dpoint.getY()+plane1.getc()*dpoint.getZ()+plane1.getd())==(plane1.geta()*point1.getX()+plane1.getb()*point1.getY()+plane1.getc()*point1.getZ()+plane1.getd()));
    assertEquals("Point is on Plane", marker1, plane1.contains(point1));
    
    Vector v2 = new Vector(2,4,5);
    Point dpoint2 = new Point(1,1,1);
    Point point2 = new Point(4,1,1);
    Plane plane2 = new Plane(dpoint2, v2);
    boolean marker2 = ((plane2.geta()*dpoint2.getX()+plane2.getb()*dpoint2.getY()+plane2.getc()*dpoint2.getZ()+plane2.getd())==(plane2.geta()*point2.getX()+plane2.getb()*point2.getY()+plane2.getc()*point2.getZ()+plane2.getd()));
    assertEquals("Point is not on Plane", marker2, plane2.contains(point2)); 
  }
  
  public void testisParallel(){
    Vector v1 = new Vector(2,4,5);
    Point point1 = new Point(1,1,1);
    Plane plane1 = new Plane(point1, v1);
    Vector v2 = new Vector(4,8,10);
    Plane plane2 = new Plane(point1, v2);
    assertEquals("Planes are parallel",Vector.isParallel(plane1.getNormal(), plane2.getNormal()), Plane.isParallel(plane1,plane2)); 
    
    Vector v3 = new Vector(2,4,5);
    Plane plane3 = new Plane(point1, v3);
    Vector v4 = new Vector(4,8,9);
    Plane plane4 = new Plane(point1, v4);
    assertEquals("Planes are not parallel",Vector.isParallel(plane3.getNormal(), plane4.getNormal()), Plane.isParallel(plane3,plane4)); 
  }
  
  public void testisOrthoganol(){
  Vector v1 = new Vector(2,4,5);
    Point point1 = new Point(1,1,1);
    Plane plane1 = new Plane(point1, v1);
    Vector v2 = new Vector(4,8,10);
    Plane plane2 = new Plane(point1, v2);
    assertEquals("Planes are Orthoganol",Vector.isOrthoganol(plane1.getNormal(), plane2.getNormal()), Plane.isOrthoganol(plane1,plane2)); 
    
    Vector v3 = new Vector(1,7,-2);
    Plane plane3 = new Plane(point1, v3);
    Vector v4 = new Vector(1,1,3);
    Plane plane4 = new Plane(point1, v4);
    assertEquals("Planes are not Orthoganol",Vector.isOrthoganol(plane3.getNormal(), plane4.getNormal()), Plane.isOrthoganol(plane3,plane4)); 
  }
}
