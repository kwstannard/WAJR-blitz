package models;

import classes.collisionShapes.Circle;
import classes.collisionShapes.CollisionShape;
import classes.objects.GameObject;
import classes.objects.Sprite;

public abstract class Character extends Circle implements Sprite {
  
  public enum Direction { LEFT }

  private State moveState;
  private State lifeState;

  public boolean isAlive() { return lifeState.toString().equals("alive"); }

  public void kill() { lifeState = new Dead(); }
  public void revive() { lifeState = new Alive(); }
  
  public void move(Direction d) {
    switch(d) {
      case LEFT: moveState = new MovingLeft();
                 break;
    }
  }

  public void checkInteractionWith(GameObject go) {
    if (isColliding(go.getCollisionShape()))
      collideWith(go);
    else
      distanceInteractionWith(go);
  }

  public CollisionShape getCollisionShape() { return this; }
  
  abstract public void collideWith(GameObject go);
  abstract public void distanceInteractionWith(GameObject go);

  abstract public void determineMove();
  public void executeTurn() {

  }
  
  abstract public double getMoveSpeed();
 
### States #####################################################################

  private abstract class State {
    public abstract void action();
    public abstract String toString();
  }

  private class MovingLeft extends State {
    public void action() { addToX( getMoveSpeed() ); }
    public String toString() { return "moving left"; }
  }

  private class Dead extends State {
    public void action() { }
    public String toString() { return "dead"; }
  }

  private class Alive extends State {
    public void action() { }
    public String toString() { return "alive"; }
  }

}
