package classes;

import static org.junit.Assert.*;

import org.junit.*;

public class CircleTest {

  Circle circle;

  @Before public void before() {
    circle = new Circle(0,0,1);
  }

  @Test
  public void test() {
    circle = new Circle(1.0,1.0,1.0);
  }

  @Test public void canDetectIfAPointIsWithinIt() {
    double rad = 1.0;
    double ffd = Math.sin(Math.PI / 4) * rad;
    circle.setRadius(rad);

    assertTrue(circle.collidesWith(new Point(0,0)));
    assertTrue(circle.collidesWith(new Point(ffd - 0.05, ffd - 0.05)));
    assertFalse(circle.collidesWith(new Point(ffd + 0.05, ffd + 0.05)));
    assertFalse(circle.collidesWith(new Point(0,rad)));
    assertFalse(circle.collidesWith(new Point(rad,rad)));
  }

  @Test public void canDetectCollisionsWithOtherGameObjects() {
    circle.setRadius(1.0);
    Circle circle2 = new Circle(0,0,0);

    assertTrue(circle.collidesWith(circle2));

    circle2.setPosition(new Point(1,1));
    assertFalse(circle.collidesWith(circle2));

    circle2.setRadius(1.0);
    assertTrue(circle.collidesWith(circle2));

    circle2.setPosition(new Point(0,2));
    assertFalse(circle.collidesWith(circle2));

    circle2.setPosition(new Point(2,0));
    assertFalse(circle.collidesWith(circle2));
  }

  @Test public void canDetectCollisionsWithARectangle() {
    circle.setRadius(1.0);
    Rectangle rec = new Rectangle(-2,-2,4,4);
    assertTrue(circle.collidesWith(rec));

    circle.setPosition(4, 0);
    assertFalse(circle.collidesWith(rec));

    circle.setPosition(2.1, 2.1);
    assertTrue(circle.collidesWith(rec));

    circle.setRadius(0.13);
    assertFalse(circle.collidesWith(rec));
  }

}
