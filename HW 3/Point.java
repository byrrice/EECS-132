/**
 * This class represents a point 
 * @author Isaac Ng
 */
public class Point{
  /**the x coordinate*/
  private double x;
  
  /**the y coordinate*/
  private double y;
  
  /**the z coordinate*/
  private double z;
  
  /**
   * Creates point with x y and z coordinates
   * @param x the desired x coordinate
   * @param y the desired y coordinate
   * @param z the desired z coordinate
   */
  public Point(double x, double y, double z){
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  /**
   * Return the x coordinate
   * @return returns the x coordinate
   */
  public double getX() {
    return x;
  }
  
  /**
   * return the y coordinate
   * @return returns the y coordinate
   */
  public double getY() {
    return y;
  }
  
  /**
   * return the z coordinate
   * @return returns the z coordinate
   */
  public double getZ() {
    return z;
  }
  
  /**
   * This returns the String representation of the point
   * @return returns the string representation of the point
   */
  @Override
  public String toString(){
    return "("+this.getX() + "," +this.getY() + "," +this.getZ() + ")";
  }
  
  /**
   * This returns the vector + point
   * @param v Vector that we are adding to the point
   * @return returns vector + point
   */
  public Point addVector(Vector v){
    return new Point(v.vgetX() + this.getX(), v.vgetY() + this.getY(), v.vgetZ() + this.getZ());
  }
  
  /**
   * This tests whether the input point is equal to the point 
   * @param o an object to compare against the point
   * @return returns true if coordinates of the two points are the same, returns false if not
   */
  @Override
  public boolean equals(Object o){
    if (o instanceof Point){
      Point p = (Point)o;
      return this.getX() == p.getX() && this.getY() == p.getY() && this.getZ() == p.getZ();
    }
    else
      return false;
  }
  
  /**
   * This computes the distance between the input points
   * @param point1 the point used to compute the distance between these aforementioned points
   * @param point2 the point used to compute the distance between these aforementioned points
   * @return returns the distance that was computed
   */
  public static double distance(Point point1, Point point2){
    double distance = Math.sqrt((point1.getX() - point2.getX() * point1.getX() - point2.getX()) + (point1.getX() - point2.getY() * point1.getX() - point2.getY()));
    return distance;
  }
}