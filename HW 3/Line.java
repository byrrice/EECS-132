/**
 * This class represents a line 
 * @author Isaac Ng
 */
public class Line{
  
  /**the first point*/
  private Point point1;
  
  /**the vector*/
  private Vector vector1;
  
  /**
   * Creates line with two points
   * @param point1 the first point
   * @param point2 the second point
   * @return returns the created vector using points
   */
  public Line(Point point1, Point point2){
    this.point1 = point1;
    this.vector1 = new Vector(point2.getX() - point1.getX(), point2.getY() - point1.getY(), point2.getZ() - point1.getZ());
  }
  
  /**
   * Creates line that runs through the point and is parallel to the vector
   * @param point1 the first point
   * @param vector1 the vector
   */
  public Line(Point point1, Vector vector1){
    this.point1 = point1;
    this.vector1 = vector1;
  }
  
    /**
   * This returns vector that is parallel to the line
   * @return returns the parallel vector 
   */
  public Vector getVector(){
    return vector1;
  }
  
  /**
   * This returns initial point
   * @return returns the initial point
   */
  public Point getPoint(){
    return point1;
  }
  
  /**
   * This returns the equation for the line as a string unless the line is vertical 
   * @return returns the line equation in string form with a special case for when the line is vertical 
   */
  @Override
  public String toString(){
    return "(" +point1.getX()+"x+" + vector1.vgetX()+ ","+point1.getY()+"y+" + vector1.vgetY()+ ","+point1.getZ()+"z+" + vector1.vgetZ()+ ")";
  }
  
  /**
   * This tests whether the input object is the same line
   * @param o an object to compare against the line
   * @return returns true if the lines are the same
   */
  @Override
  public boolean equals(Object o){
    if (o instanceof Line){
      Line l = (Line)o;
      
      //p2 point on other line
      Point p1 = l.getPoint();
      
      //p2 point on other line
      Point p2 = l.getPoint().addVector(l.getVector()); 
      return isOnLine(p1) && isOnLine(p2);
    }
    else
      return false;
  }
  
  /**
   * This tests whether the input object is on the line
   * @param p a point to test whether is on line
   * @return returns true if it is on the line, false if not
   */
  public boolean isOnLine(Point p){
    
    //difference between points in the x direction
    double xdifference = getPoint().getX() - p.getX();
    
    //difference between points in the y direction
    double ydifference = getPoint().getY() - p.getY();
    
    //difference between points in the z direction
    double zdifference = getPoint().getZ() - p.getZ();
    
    //the vector of the x, y and z difference
    Vector difference = new Vector(xdifference, ydifference, zdifference);
    return Vector.isParallel(difference, this.getVector());
  }
  
  /**
   * This computes whether the two lines are parallel to each other
   * @param line1 the first of the two lines compared against each other
   * @param line2 the second of the two lines compared against each other
   * @return returns true if parallel, else false
   */
  public static boolean isParallel(Line line1, Line line2){
    if ((line1.getVector()).unitVector() == (line2.getVector()).unitVector())
      return true;
    else
      return false;
  }
  
  /**
   * returns the point of intersection between 2 lines if any
   * @param line1 the first line in 3d
   * @param line2 the second line in 3d
   * @return returns the point of intersection, null if no point of intersection
   */
  public static Point intersection(Line line1, Line line2){
    if (Vector.isParallel(line1.getVector(), line2.getVector()))
      return null;
    else{
      
      //the cross product of the line1 and line2's slope vector
      Vector cross1 = Vector.crossProduct(line1.getVector(), line2.getVector());
      
      //cross product of slope vector and the above cross product
      Vector cross2 = Vector.crossProduct(line1.getVector(), cross1);
      
      //finding the constant to find the intersection
      double constant = Vector.dotProduct(cross2, line1.getVector());
      
      //finding the place where they intersect
      double intersection = (constant - Vector.dotProduct(cross2, line2.getVector())/Vector.dotProduct(cross2, line1.getVector()));
      
      //defining the point where they intersect
      Point m1 =  new Point(line1.point1.getX()+line2.point1.getX()*intersection, line1.point1.getY()+line2.point1.getY()*intersection, line1.point1.getZ()+line2.point1.getZ()*intersection);
      return m1;
    }
  }
}
