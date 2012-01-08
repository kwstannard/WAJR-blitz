package classes;

public class Circle implements Cloneable, BoundingBox {

  double radius, x, y;
  Rectangle bounds;
  boolean boundsChanged = true;

  Circle (int x, int y, int radius) {
    this((double)x, (double)y, (double)radius);
  }

  Circle (double x, double y, double radius) {
    this.radius = radius;
    this.x = x; this.y = y;
  }

  // Accessors ################################################# 
  public double getRadius() {return radius;}
  public double getWidth() {return getRadius() * 2;}
  public double getX() {return x;}
  public double getY() {return y;}
  public Point getPosition() { return new Point(getX(), getY()); }

  // Setters ####################################################
  public void setRadius(double r) {radius = r; boundsChanged = true;}

  public void setX(double x) {this.x = x; boundsChanged = true;}
  public void addToX(double i) {x += i; boundsChanged = true;}
  public void setY(double y) {this.y = y; boundsChanged = true;}
  public void addToY(double i) {y += i; boundsChanged = true;}
  public void setPosition(Point p) { setY(p.getY()); setX(p.getX()); boundsChanged = true; }
  public void setPosition(int x, int y) { setY(y); setX(x);  boundsChanged = true;}
  public void setPosition(double x, double y) { setY(y); setX(x);  boundsChanged = true;}

  public boolean collidesWith(Point p) { return distanceTo(p) < getRadius(); }

  public boolean collidesWith(Rectangle r) {
    double rad = getRadius(), x = r.getX(), y = r.getY(), w = r.getWidth(), h = r.getHeight();

    Rectangle s = new Rectangle(x + rad, y, w - 2 * rad, h);
    if (s.collidesWith(getBoundBox())) { return true; }

    s = new Rectangle(x, y + rad, w, h - 2 * rad);
    if (s.collidesWith(getBoundBox())) { return true; }

    for (Point p : r.getCorners()) {
      if (collidesWith(p)) { return true; }
    }

    return false;
  }

  public boolean collidesWith(Circle c) {
    return distanceTo(c) < c.getRadius() + getRadius();
  }

  public boolean collidesWith(double x, double y) {
    return collidesWith(new Point(x,y));
  }
  public boolean collidesWith(double x, double y, double w, double h) {
    return collidesWith(new Rectangle(x,y,w,h));
  }

  public Rectangle getBoundBox() {
    if (boundsChanged) { remakeBoundBox(); }
    return bounds;
  }

//##################################################

  private double distanceTo(Circle c) { return distanceTo(c.getPosition()); }
  private double distanceTo(Point p) {
    double delX = p.getX() - getX();
    double delY = p.getY() - getY();
    return Geom.hypot(delX, delY);
  }

  private void remakeBoundBox() {
    bounds = new Rectangle(
        (getX() - getRadius()),
        (getY() - getRadius()),
        getWidth(), getWidth());
    boundsChanged = false;
  }

  public String toString() {
    return String.format("%f, %f, %f", getX(), getY(), getRadius());
  }

}
