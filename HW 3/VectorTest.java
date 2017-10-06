import junit.framework.TestCase;

public class VectorTest extends TestCase {
  
  public void testtoString(){
    Vector v = new Vector(4.1,4.1,4.1);
    assertEquals("Shows vector as string", v.toString(), "<4.1,4.1,4.1>");
  }
  
  public void testequals() {
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    assertFalse("two different vectors", v1.equals(v2));
    
    Point p1 = new Point(2,3,4);
    assertFalse("not even a vector", v1.equals(p1));
    
    Vector v3 = new Vector(3,4,5);
    assertEquals("The same vector", v1, v3);
  }
  
  public void testmagnitude(){
    Vector v1 = new Vector(3,4,5);
    double magnitude = Math.sqrt(Vector.dotProduct(v1,v1));
    assertEquals("Testing the magnitudes", magnitude, v1.magnitude());
  }
  
  public void testunitvector(){
    Vector v1 = new Vector(3,4,5);
    Vector unitvector = new Vector(v1.vgetX()/v1.magnitude(), v1.vgetY()/v1.magnitude(), v1.vgetZ()/v1.magnitude());
    assertEquals("Testing the unitvector", unitvector, v1.unitVector());
  }
  
  public void testsum() {
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    Vector sumvector = new Vector(v1.vgetX()+v2.vgetX(), v1.vgetY()+v2.vgetY(),v1.vgetZ()+v2.vgetZ());
    assertEquals("Testing the sumvector", sumvector, Vector.sum(v1, v2));
  }
  
  public void testscaleVector() {
    Vector v1 = new Vector(3,4,5);
    double multiplier = 3;
    Vector scalevector = new Vector(v1.vgetX()*multiplier, v1.vgetY()*multiplier,v1.vgetZ()*multiplier);
    assertEquals("Testing the scalevector", scalevector, Vector.scale(v1, 3));
  }
  
  public void testdotProduct() {
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    double dotproduct = v1.vgetX()*v2.vgetX() + v1.vgetY()*v2.vgetY() + v1.vgetZ()*v2.vgetZ();
    assertEquals("Testing the dotproduct", dotproduct, Vector.dotProduct(v1, v2));
  }
  
  public void testcrossProduct() {
    Vector vector1 = new Vector(3,4,5);
    Vector vector2 = new Vector(2, 4, 5);
    Vector crossproduct = new Vector((vector1.vgetY()*vector2.vgetZ() - vector1.vgetZ()*vector2.vgetY()),-1*(vector1.vgetX()*vector2.vgetY() - vector1.vgetZ()*vector2.vgetX()),(vector1.vgetX()*vector2.vgetY() - vector1.vgetY()*vector2.vgetX()))  ;
    assertEquals("Testing the crossproduct", crossproduct, Vector.crossProduct(vector1, vector2));
  }
  
  public void testangle(){
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    double angle = (Vector.dotProduct(v1, v2))/(v1.magnitude()*v2.magnitude());
    assertEquals("Testing the angle", angle, Vector.angle(v1, v2));
  }
  
  public void testisOrthoganol(){
    Vector v1 = new Vector(3,4,5);
    Vector v2 = new Vector(2, 4, 5);
    double dotproduct = Vector.dotProduct(v1, v2);
    assertEquals("Two vectors not Orthoganol", false, Vector.isOrthoganol(v1, v2));
    Vector v3 = new Vector(1,1,3);
    Vector v4 = new Vector(1, -7, 2);
    double dotproduct2 = Vector.dotProduct(v3, v4);
    assertEquals("Two vectors that are Orthoganol", true, Vector.isOrthoganol(v3, v4));
  }
  
    public void testisParallel(){
    Vector v1 = new Vector(2,2,2);
    Vector v2 = new Vector(4, 4, 4);
    boolean value = true;
    if (Vector.crossProduct(v1, v2).vgetX() == 0 && Vector.crossProduct(v1, v2).vgetY() == 0 && Vector.crossProduct(v1, v2).vgetZ() == 0)
      value = true;
    else
      value = false;
    assertEquals("Two parallel vectors", value, Vector.isParallel(v1, v2));
    
    Vector v3 = new Vector(1,1,3);
    Vector v4 = new Vector(1, -7, 2);
    if (Vector.crossProduct(v3, v4).vgetX() == 0 && Vector.crossProduct(v3, v4).vgetY() == 0 && Vector.crossProduct(v3, v4).vgetZ() == 0)
      value = true;
    else
      value = false;
    assertEquals("Two non-parallel vectors", value, Vector.isParallel(v3, v4));
  }
}