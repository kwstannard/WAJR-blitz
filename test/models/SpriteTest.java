package models;

import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.junit.*;

import app.ImageObject;
import classes.Point2D;

public class SpriteTest {

  Sprite sprite;
  ImageObject imageObject;

  @Before public void before() {
    imageObject = Mockito.mock(ImageObject.class);
    sprite = new Sprite(imageObject);
  }

  @Test public void maintainFrameCount() {
    assertEquals(0, sprite.frame);
    sprite.nextFrame();
    assertEquals(1, sprite.frame);
  }

  @Test public void frameCountReturnsToZeroAfterLastFrame() {
    Mockito.when(imageObject.isLastFrame(2)).thenReturn(true);
    sprite.nextFrame();
    sprite.nextFrame();
    assertEquals(0, sprite.frame);
  }

  @Test public void tellsImageObjectWhatFrameToDrawAndThePosition() {
    sprite.nextFrame();
    sprite.draw();
    Mockito.verify(imageObject).draw(1, 0, 0);
  }

  @Test public void alwaysStartsAtZeroZero() {
    assertTrue(new Point2D(0, 0).equals(sprite.position()));
  }

  @Test public void canMoveLeftAndRight() {
    sprite.moveLeft();
    assertTrue(sprite.position().getX() < 0);
    sprite.moveRight();
    assertTrue(sprite.position().getX() == 0);
  }

  @Test public void canMoveUpAndDown() {
    sprite.moveUp();
    assertTrue(sprite.position().getY() < 0);
  }
}
