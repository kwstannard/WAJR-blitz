package classes.objects;

import classes.collisionShapes.CollisionShape;

public interface GameObject {

  //public abstract boolean isColliding (GameObject go);

  //accessors
  public abstract boolean isAlive();
  public abstract CollisionShape getCollisionShape();

  // setters
  public abstract void kill();
  public abstract void revive();

  public abstract void executeTurn();
  public abstract void determineMove();

}
