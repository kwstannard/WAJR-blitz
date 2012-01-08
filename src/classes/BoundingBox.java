package classes;

public interface BoundingBox {
  
  abstract public boolean collidesWith(Point p);
  abstract public boolean collidesWith(Circle c);
  abstract public boolean collidesWith(Rectangle r);

}
