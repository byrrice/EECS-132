/**
 * This class represents a line in 2D space
 * @author Isaac Ng
 */
public class Line2D extends Line{
  
  /**
   * Creates line with two points of type Point2D
   * @param point1 the first point
   * @param point2 the second point
   */
  public Line2D(Point2D point1, Point2D point2){
    super(point1, point2);
  }
  
  /**
   * This returns the equation for the line as a string unless the line is vertical 
   * @return returns the line equation in string form with a special case for when the line is vertical 
   */
  @Override
  public String toString(){
    
    if (getVector().vgetX() == 0)
      return "x=" + getPoint().getX();
    else{
      
      //slope of the line
      double slope = getVector().vgetY()/getVector().vgetX();
      
      //y - intercept of the line
      double intercept = getPoint().getY() - slope * getPoint().getX();
      return "y=" +slope+"x+"+intercept; 
    }
  }
  
  /**
   * This returns if the lines intersect with each other
   * @param line1 the first line we are using to check if there is an intersection
   * @param line2 the second line we are using to check if there is an intersection
   * @return returns null if not intersection, if it does intersect, returns the point 
   */
  public static Point2D intersection(Line2D line1, Line2D line2){
    if (Vector.isParallel(line1.getVector(), line2.getVector()))
      return null;
    else{
      
      //slope of the line
      double slope1 = line1.getVector().vgetY()/line1.getVector().vgetX();
      
      //y - intercept of the line
      double intercept1 = line1.getPoint().getY() - slope1 * line1.getPoint().getX();
      
      //slope of the line
      double slope2 = line2.getVector().vgetY()/line2.getVector().vgetX();
      
      //y - intercept of the line
      double intercept2 = line2.getPoint().getY() - slope2 * line2.getPoint().getX();
      Point2D intersection = new Point2D(((intercept1-intercept2)/(slope2-slope1)), ((intercept1-intercept2)/(slope2-slope1))*slope1 + intercept1); 
      return intersection;
    }
  }
}
