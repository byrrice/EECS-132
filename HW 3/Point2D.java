/**
 * This class represents a point in a 2D plane
 * @author Isaac Ng
 */
public class Point2D extends Point{
  
  /**
   * Creates point with x and y coordinate
   * @param x the desired x coordinate
   * @param y the desired y coordinate
   */
  public Point2D(double x, double y){
    super(x, y, 0);
  }
  
  /**
   * This returns the String representation of the point
   * @return returns the string representation of the point
   */
  @Override
  public String toString(){
    return "("+this.getX() + "," +this.getY() +")";
  }
}