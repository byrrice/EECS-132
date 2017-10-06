/**
 * This class represents a plane
 * @author Isaac Ng
 */
public class Plane{
  
  //the a of the plane equation
  private double a;
  
  //the b of the plane equation
  private double b;
  
  //the c of the plane equation
  private double c;
  
  //the d/constant of the plane equation
  private double d;
  
  //the point that defines the plane
  private Point dpoint;
  
  /**
   * Creates plane with point and vector
   * @param point1 the point used to create the plane
   * @param vector1 the normal vector used to create the plane
   */
  public Plane(Point point1, Vector vector1){
    this.a = vector1.vgetX();
    this.b = vector1.vgetY();
    this.c = vector1.vgetZ();
    this.d = -1*(point1.getX()*vector1.vgetX())+-1*(point1.getY()*vector1.vgetY())+-1*(point1.getZ()*vector1.vgetZ());
    this.dpoint = point1;
  }
  
  /**
   * Creates plane using three points
   * @param point1 the first point used to create the plane
   * @param point2 the second point used to create the plane
   * @param point3 the third point used to create the plane
   */
  public Plane(Point point1, Point point2, Point point3){
    
    //creates the first vector based on point2 and point1
    Vector vector1 = new Vector(point2.getX()-point1.getX(), point2.getY()-point1.getY(),point2.getZ()-point1.getZ());
    
    //creates the second vector based on point3 and point2
    Vector vector2 = new Vector(point3.getX()-point2.getX(), point3.getY()-point2.getY(),point3.getZ()-point2.getZ());
    
    //The normal vector
    Vector crossvector = new Vector((vector1.vgetY()*vector2.vgetZ() - vector1.vgetZ()*vector2.vgetY()),-1*(vector1.vgetX()*vector2.vgetY() - vector1.vgetZ()*vector2.vgetX()),(vector1.vgetX()*vector2.vgetY() - vector1.vgetY()*vector2.vgetX()));
    
    this.a = crossvector.vgetX();
    this.b = crossvector.vgetY();
    this.c = crossvector.vgetZ();
    this.d = -1*(point1.getX()*crossvector.vgetX())+-1*(point1.getY()*crossvector.vgetY())+-1*(point1.getZ()*crossvector.vgetZ());
    this.dpoint = point1;
  }
  
  /**
   * Return the a parameter
   * @return returns the a parameter of the plane
   */
  public double geta() {
    return a;
  }
  
  /**
   * return the b parameter
   * @return returns the b parameter of the plane
   */
  public double getb() {
    return b;
  }
  
  /**
   * return the c parameter
   * @return returns the c parameter of the plane
   */
  public double getc() {
    return c;
  }
  
  
  /**
   * return the d parameter
   * @return returns the d parameter of the plane
   */
  public double getd() {
    return d;
  }
  
  /**
   * This returns the normal vector
   * @return returns length of the vector
   */
  public Vector getNormal(){
    
    //the length of the vector
    Vector normalvector = new Vector(this.geta(), this.getb(), this.getc());
    
    return normalvector;
  }
  
  /**
   * This returns the string representation of the plane
   * @return returns the string representation of the plane
   */
  @Override
  public String toString(){
    return ""+this.geta()+"x + "+this.getb()+"y + "+this.getc()+"z + "+this.getd()+" = 0";
  }
  
  /**
   * This tests whether the input plane is equal to the plane
   * @param o an object to compare against the plane
   * @return returns true if plane is same
   */
  @Override
  public boolean equals(Object o){
    if (o instanceof Plane){
      Plane p = (Plane)o;
      return this.getd() == p.getd() && Vector.isParallel(p.getNormal(), this.getNormal()); 
    }
    else
      return false;
  }
  
  /**
   * This tests whether the input point is on the plane
   * @param point1 point that is being tested for being on the plane
   * @return returns true if point is one plane, false if not
   */
  public boolean contains(Point point1){
    if ((this.geta()*dpoint.getX()+this.getb()*dpoint.getY()+this.getc()*dpoint.getZ()+this.getd())==(this.geta()*point1.getX()+this.getb()*point1.getY()+this.getc()*point1.getZ()+this.getd()))
      return true;
    else 
      return false;
  }
  
  /**
   * This calculates whether two planes are parallel to each other
   * @param plane1 the first plane
   * @param plane2 the second plane
   * @return returns true if parallel, false if not
   */
  public static boolean isParallel(Plane plane1, Plane plane2){
    return Vector.isParallel(plane1.getNormal(), plane2.getNormal());
  }
  
  /**
   * This calculates whether two planes are orthogonal to each other
   * @param plane1 the first plane
   * @param plane2 the second plane
   * @return returns true if orthogonal, false if not
   */
  public static boolean isOrthoganol(Plane plane1, Plane plane2){
    return Vector.isOrthoganol(plane1.getNormal(), plane2.getNormal());
  }
}