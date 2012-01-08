package classes;

public class Rectangle implements Cloneable, BoundingBox {

  double x, y, width, height;

  //empty constructor
  public Rectangle() { this(0.0,0.0,0.0,0.0); }

  //int constructor
  public Rectangle(int x, int y, int w, int h) {
    this((double)x, (double)y, (double)w, (double)h);
  }
  //double constructor
  public Rectangle(double x, double y, double w, double h) {
    setX(x);
    setY(y);
    setWidth(w);
    setHeight(h);
  }

  public double getX() { return x; }
  public double getY() { return y; }
  public double getWidth() { return width; }
  public double getHeight() { return height; }

  public void setX(double x) { this.x = x; }
  public void setX(int x) { this.x = x; }
  public void setY(double y) { this.y = y; }
  public void setY(int y) { this.y = y; }

  public void setWidth(double w) { width = w; }
  public void setWidth(int w) { width = w; }
  public void setHeight(double h) { height = h; }
  public void setHeight(int h) { height = h; }

  public boolean collidesWith(Point p) {
    if (p.getX() < getX()) { return false; }
    if (p.getY() < getY()) { return false; }
    if (p.getX() > getX() + getWidth()) { return false; }
    if (p.getY() > getY() + getHeight()) { return false; }
    return true;
  }

  public boolean collidesWith(Rectangle r) {
    if (r.getX() + r.getWidth() < getX()) { return false; }
    if (r.getY() + r.getHeight() < getY()) { return false; }
    if (r.getX() > getX() + getWidth()) { return false; }
    if (r.getY() > getY() + getHeight()) { return false; }
    return true;
  }

  public boolean collidesWith(Circle c) {
    return c.collidesWith(this);
  }

  public Point[] getCorners() {
    Point[] points = {new Point(x,y), new Point(x+width,y),
      new Point(x,y+height), new Point(x+width,y+height)};
    return points;
  }
  
}
