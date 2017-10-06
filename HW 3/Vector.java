/**
 * This class represents a vector
 * @author Isaac Ng
 */
public class Vector{
  
  /**the x coordinate to make the vector*/
  private double x;
  
  /**the y coordinate coordinate to make the vector*/
  private double y;
  
  /**the z coordinate to make the vector*/
  private double z;
  
  /**
   * Creates vector with x y and z coordinates
   * @param x the desired x coordinate
   * @param y the desired y coordinate
   * @param z the desired z coordinate
   */
  public Vector(double x, double y, double z){
    this.x = x;
    this.y = y;
    this.z = z;
  }
  /**
   * Creates vector with point values
   * @param point1 the point used to create the vector
   */
  public Vector(Point point1){
    this.x = point1.getX();
    this.y = point1.getY();
    this.z = point1.getZ();
  }
  
  /**
   * Creates vector with initial vector and length parameter
   * @param vector1 the vector to be remade
   * @param length the length of the new vector
   */
  public Vector(Vector vector1, double length){
    
    //the oldlength of the vector
    double oldlength = Math.sqrt(vector1.vgetX()*vector1.vgetX() + vector1.vgetY()*vector1.vgetY());
    
    //the ratio we will multiply by to find the new length
    double ratio = length/oldlength;
    
    this.x = vector1.vgetX() * ratio;
    this.y = vector1.vgetY() * ratio;
    this.z = vector1.vgetZ() * ratio;
  }
  
  /**
   * Return the x parameter
   * @return returns the x parameter
   */
  public double vgetX() {
    return x;
  }
  
  /**
   * return the y parameter
   * @return returns the y parameter
   */
  public double vgetY() {
    return y;
  }
  
  /**
   * return the z parameter
   * @return returns the z parameter
   */
  public double vgetZ() {
    return z;
  }
  
  /**
   * This returns the String representation of the vector
   * @return returns the string representation of the vector
   */
  @Override
  public String toString(){
    return "<"+this.vgetX() + "," +this.vgetY() + "," +this.vgetZ() + ">";
  }
  
  
  /**
   * This tests whether the input vector is equal to the vector created
   * @param o an object to compare against the vector
   * @return returns true if vectors are the same, false if not
   */
  @Override
  public boolean equals(Object o){
    if (o instanceof Vector){
      Vector v = (Vector)o;
      return this.vgetX() == v.vgetX() && this.vgetY() == v.vgetY() && this.vgetZ() == v.vgetZ();
    }
    else
      return false;
  }
  
  /**
   * This returns the length of the vector
   * @return returns length of the vector
   */
  public double magnitude(){
    
    //the length of the vector
    double magnitude = Math.sqrt(dotProduct(this, this));
    
    return magnitude;
  }
  
  /**
   * This makes a new vector that has length 1
   * @return returns a unit vector
   */
  public Vector unitVector(){
    
    //creating the unitvector
    Vector unitvector = new Vector(this.vgetX()/this.magnitude(), this.vgetY()/this.magnitude(), this.vgetZ()/this.magnitude());
    return unitvector;
  }
  
  /**
   * This makes a new vector that is the sum of the two input vector
   * @param vector1 the first vector to be added
   * @param vector2 the second vector to be added
   * @return returns a sum vector
   */
  public static Vector sum(Vector vector1, Vector vector2){
    
    //creating the new sum vector
    Vector sumvector = new Vector(vector1.vgetX()+vector2.vgetX(), vector1.vgetY()+vector2.vgetY(),vector1.vgetZ()+vector2.vgetZ());
    
    return sumvector;
  }
  
  /**
   * This makes a new vector that is scaled by the multiplier
   * @param vector1 the vector to be scaled
   * @param multiplier the multiplier of the vector
   * @return returns the new scaled vector
   */
  public static Vector scale(Vector vector1, double multiplier){
    
    //creating the new scaled vector
    Vector scalevector = new Vector(vector1.vgetX()*multiplier, vector1.vgetY()*multiplier,vector1.vgetZ()*multiplier);
    
    return scalevector;
  }
  
  /**
   * This calculates the dot product of the two vectors
   * @param vector1 the first vector
   * @param vector2 the second vector
   * @return returns the dot product
   */
  public static double dotProduct(Vector vector1, Vector vector2){
    
    //calculating the dot product
    double dotproduct = vector1.vgetX()*vector2.vgetX() + vector1.vgetY()*vector2.vgetY() + vector1.vgetZ()*vector2.vgetZ();
    
    return dotproduct;
  }
  
  /**
   * This calculates the cross product of the two vectors
   * @param vector1 the first vector
   * @param vector2 the second vector
   * @return returns the cross product
   */
  public static Vector crossProduct(Vector vector1, Vector vector2){
    
    //calculating the cross product
    Vector crossproduct = new Vector((vector1.vgetY()*vector2.vgetZ() - vector1.vgetZ()*vector2.vgetY()),-1*(vector1.vgetX()*vector2.vgetY() - vector1.vgetZ()*vector2.vgetX()),(vector1.vgetX()*vector2.vgetY() - vector1.vgetY()*vector2.vgetX()))  ;
    
    return crossproduct;
  }
  
  /**
   * This calculates the angle between two vectors
   * @param vector1 the first vector
   * @param vector2 the second vector
   * @return returns the angle from the first vector to the second vector
   */
  public static double angle(Vector vector1, Vector vector2){
    
    //calculating the angle
    double angle = (dotProduct(vector1, vector2))/(vector1.magnitude()*vector2.magnitude());
    
    return angle;
  }
  
  /**
   * This calculates whether two vectors are orthoganol to each other
   * @param vector1 the first vector
   * @param vector2 the second vector
   * @return returns true if orthoganol, false if not
   */
  public static boolean isOrthoganol(Vector vector1, Vector vector2){
    
    //getting the value of the dotproduct
    double dotproduct = dotProduct(vector1, vector2);
    if (dotproduct == 0)
      return true;
    else
      return false;
  }
  
  /**
   * This calculates whether two vectors are parallel to each other
   * @param vector1 the first vector
   * @param vector2 the second vector
   * @return returns true if parallel, false if not
   */
  public static boolean isParallel(Vector vector1, Vector vector2){
    if (crossProduct(vector1, vector2).vgetX() == 0 && crossProduct(vector1, vector2).vgetY() == 0 && crossProduct(vector1, vector2).vgetZ() == 0)
      return true;
    else
      return false;
  }
}