package app;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

import classes.Point2D;


public class ImageObject {

  protected Image image;
  protected Applet applet;
  protected AffineTransform at;
  protected Graphics2D g2d;

  private int totalFrames;
  public int frame = 0;

  ImageObject() {
    setImage(null);
  }

  public void nextFrame() {
    frame++;
    if (isLastFrame())
      frame = 0;
  }

  public boolean isLastFrame() {
    return frame == totalFrames;
  }

  public void setImage(Image image, int frames) {
    this.image = image;
    totalFrames = frames;
  }

  public Image getImage() {return image;}
  //TODO return circle shape

  public void setGraphics( Graphics2D g) {g2d = g;}
  public void setImage(Image image) {
    this.image = image;
  }

  private URL getURL(String filename) {
    URL url = null;
    try {
      url = this.getClass().getResource(filename);
    } catch (Exception e) {}
    return url;
  }
  public void load (String filename) {
    Toolkit tk = Toolkit.getDefaultToolkit();
    image = tk.getImage(getURL(filename));
    while(getImage().getWidth(applet) <= 0);
    double x = applet.getWidth() / 2 - getWidth() / 2;
    double y = applet.getHeight() / 2 - getWidth() / 2;
    at = AffineTransform.getTranslateInstance(x, y);
  }

  public void transform() {
    at.setToIdentity();
    at.translate((int)getX() + getWidth() / 2, (int)getY() + getWidth() / 2);
    at.translate(getWidth() / 2, getWidth() / 2);
  }

  public void draw(int frame, double x, double y) {
    g2d.drawImage(getImage(), at, applet);
  }

  public void drawBounds(Color c) {
    g2d.setColor(c);
    g2d.draw(getBounds());
  }

}
