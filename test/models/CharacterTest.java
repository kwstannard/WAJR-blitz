package models;

import classes.objects.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {

  private class Subject extends Character {
    public double getMoveSpeed() { return 5; }
    public void collideWith(GameObject go) { revive(); }
    public void distanceInteractionWith(GameObject go) { kill(); }
    public void determineMove() { move(Character.LEFT); }
  }

  Subject subject;

  @Before public void before() {
    subject = new Subject();
    subjectDead();
  }

  @Test public void aliveTesting() {
    subject.revive();
    subjectAlive();

    subject.kill();
    subjectDead();

    subject.setAlive(true);
    subjectAlive();
  }

  @Test public void collidesTesting() {
    Subject thing = new Subject();
    subject.setRadius(1);

    subject.checkInteractionWith(thing);
    subjectAlive();

    thing.setX(4);
    subject.checkInteractionWith(thing);
    subjectDead();
  }
  
  @Test public void moveTesting() {
    subject.determineMove();
    subject.executeMove();
    assertEquals(subject.getX(), -1);
  }

  private void subjectAlive() { assertTrue(subject.isAlive()); }
  private void subjectDead() { assertFalse(subject.isAlive()); }

}
