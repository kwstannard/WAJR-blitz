package classes;

import static org.junit.Assert.*;

import org.junit.*;

public class RectangleTest {

  Rectangle rec;

  @Before public void before() {
    rec = new Rectangle();
  }

  @Test public void constructorTest() {
    assertTrue(0 == rec.getX());
    rec = new Rectangle(1,1,1,1);
    rec = new Rectangle(1.0,1.0,1.0,1.0);
    rec = new Rectangle(1f,1f,1f,1f);
    assertTrue(1 == rec.getX());
  }

  @Test public void canIterateCorners() {
    int i = 0;
    for (Point corner : rec.getCorners()) {
      i++;
      assertTrue(corner.equals(new Point()));
    }
    assertTrue(4 == i);
  }

  @Test public void rectangleIntersectionTest() {
    Rectangle rec2 = new Rectangle();
    assertTrue(rec.collidesWith(rec2));

    rec2 = new Rectangle(0,-1,2,2);
    assertTrue(rec.collidesWith(rec2));

    rec2 = new Rectangle(-1,0,2,2);
    assertTrue(rec.collidesWith(rec2));

    rec2 = new Rectangle(-1,-1,1,2);
    assertTrue(rec.collidesWith(rec2));

    rec2 = new Rectangle(-1,-1,2,1);
    assertTrue(rec.collidesWith(rec2));

    rec2 = new Rectangle(1,1,1,1);
    assertFalse(rec.collidesWith(rec2));

    rec2 = new Rectangle(-1,-1,0,0);
    assertFalse(rec.collidesWith(rec2));
  }

  @Test public void pointContainmentTest() {
    Point point = new Point();
    assertTrue(rec.collidesWith(point));

    point = new Point(1,1);
    assertFalse(rec.collidesWith(point));

    point = new Point(-1,-1);
    assertFalse(rec.collidesWith(point));
  }

}
