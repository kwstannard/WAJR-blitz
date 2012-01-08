package app;


import static org.junit.Assert.*;
import org.junit.*;

import classes.*;

public class GameObjectTest {

  GameObject go;

  @Before public void before() {
    go = new GameObject();
  }

  @Test public void startsDeadAndHasAccessors() {
    assertFalse(go.isAlive());
    go.revive();
    assertTrue(go.isAlive());
    go.kill();
    assertFalse(go.isAlive());
  }

  @Test public void checksCollisionsWithOtherGameObjects () {
    go = new GameObject();
    go.setBoundingBox( new Circle(0,0,2) );
    GameObject go2 = new GameObject();
    go2.setBoundingBox( new Point(3,3) );
    assertFalse(go.collidesWith(go2));
  }

}
