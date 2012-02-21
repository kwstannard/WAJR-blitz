package classes.objects;

import classes.collisionShapes.CollisionShape;

public interface Sprite extends GameObject {

  public abstract boolean isAlive();

  public abstract CollisionShape getCollisionShape();
  public abstract void collideWith(GameObject go);

  public abstract void kill();
  
  public abstract void executeTurn();
  public abstract void determineMove();

}
