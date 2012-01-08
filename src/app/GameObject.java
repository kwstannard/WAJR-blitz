package app;

import classes.Geom;
import classes.BoundingBox;

public class GameObject {
  private boolean isAlive;
  private BoundingBox box;

  GameObject() {
    kill();
  }

  public boolean collidesWith (GameObject go) { 
    return box.collidesWith(go.getBoundingBox); 
  }

  //accessors
  public boolean isAlive() {return isAlive;}
  public BoundingBox getBoundingBox() { return box; }

  //mutators
  public void revive() {isAlive = true;}
  public void kill() {isAlive = false;}
  public void setAlive(boolean b) { isAlive = b; }
  public void setBoundingBox(BoundingBox box) { this.box = box; }

}
