package classes;

public class Point implements Cloneable, BoundingBox {

  double x,y;

  public Point() { this(0.0,0.0); }

  //int constructor
  public Point(int x, int y) {
    this((double)x, (double)y);
  }
  //double constructor
  public Point(double x, double y) {
    setX(x);
    setY(y);
  }
  
  //X property
  public void setX(double x) { this.x = x; }
  public void setX(int x) { this.x = (double) x; }

  //Y property
  public void setY(double y) { this.y = y; }
  public void setY(int y) { this.y = (double) y; }

  // accessors
  public double getX() { return x; }
  public double getY() { return y; }

  public boolean collidesWith(Point p) { return equals(p); }
  public boolean collidesWith(Rectangle r) { return r.collidesWith(this); }
  public boolean collidesWith(Circle c) { return c.collidesWith(this); }

  public boolean equals(Point p) {
    return getX() == p.getX() && getY() == p.getY();
  }

}
