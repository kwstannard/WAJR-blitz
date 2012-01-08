package models;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import classes.Point2D;

import app.ImageObject;


public class Sprite {

  public ImageObject imageStrip;
  public double x = 0;
  public double y = 0;
  public double moveSpeed = 2;

  public Sprite (ImageObject imgObject) {
    imageStrip = imgObject;
    x = 0; y = 0;
  }

  public void nextFrame() {
    imageStrip.nextFrame();
  }

  public void draw() {
    imageStrip.draw(frame, x, y);
  }

  public Point2D position() {
    return new Point2D(x, y);
  }

  public void moveLeft() { setX(x - moveSpeed); }
  public void moveRight() { setX(x + moveSpeed); }
  public void moveUp() { setY(y - moveSpeed); }
  public void moveDown() { setY(y + moveSpeed); }

  public void setX(double x) { this.x = x; }
  public void setY(double y) { this.y = y; }
  public void setX(int x) { setX((double)x); }
  public void setY(int y) { setY((double)y); }

  public void setMoveSpeed (double speed) { moveSpeed = speed; }
}
