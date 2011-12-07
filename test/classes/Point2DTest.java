package classes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class Point2DTest {

  int x,y;
  Point2D p;

  @Before public void before() {
    x = 1; y = 2;
    p = new Point2D(x, y);
  }

  @Test
  public void takesFloat() {
    new Point2D(1.0f, 1.0f);
  }

  @Test
  public void takesDouble() {
    new Point2D(1.0, 1.0);
  }

  @Test
  public void getXReturnsX() {
    assertTrue(p.getX() == x);
  }

  @Test
  public void getYReturnsY() {
    assertTrue(p.getY() == y);
  }

  @Test
  public void setXTakesIntsFloatsDoubles() {
    p.setX(3);
    assertTrue(p.getX() == 3);
    p.setX(3f);
    assertTrue(p.getX() == 3);
    p.setX(3.0);
    assertTrue(p.getX() == 3);
  }

  @Test
  public void setYTakesIntsFloatsDoubles() {
    p.setY(3);
    assertTrue(p.getY() == 3);
    p.setY(3f);
    assertTrue(p.getY() == 3);
    p.setY(3.0);
    assertTrue(p.getY() == 3);
  }

  @Test public void equalsIsTrueIfTwoPointsAreAtSameSpot() {
    assertFalse(p.equals(new Point2D(0.0,2.5)));
    assertTrue(p.equals(new Point2D(1.0,2.0)));
  }

}
