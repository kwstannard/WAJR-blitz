package app;

import java.applet.Applet;
import java.awt.Image;

import org.mockito.Mockito;
import static org.junit.Assert.*;

import org.junit.*;

public class ImageObjectTest {
  
  ImageObject imageObject;
  Applet applet;

  @Before public void before() {
    imageObject = new ImageObject();
    applet = Mockito.mock(Applet.class);
  }

  @Test public void maintainFrameCount() {
    assertEquals(0, imageObject.frame);
    imageObject.nextFrame();
    assertEquals(1, imageObject.frame);
  }

  @Test public void ifThereIsOnlyOneFrameThenCountIsAlwaysOne() {
    imageObject.setImage(Mockito.mock(Image.class), 1);
    assertEquals(0, imageObject.frame);
    imageObject.nextFrame();
    assertEquals(0, imageObject.frame);
  }
  @Test public void frameCountReturnsToZeroAfterLastFrame() {
    imageObject.setImage(Mockito.mock(Image.class), 2);
    imageObject.nextFrame();
    imageObject.nextFrame();
    assertEquals(0, imageObject.frame);
  }

}
