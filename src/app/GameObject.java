package app;
import java.awt.Rectangle;

import classes.Point2D;


public class GameObject {
	protected boolean isAlive;
	protected double radius;
	protected double x, y;
	protected double velX, velY;
	protected double moveAngle;

	GameObject() {
		setAlive(false);
		setX(0);
		setY(0);
		setVelX(0);
		setVelY(0);
		setMoveAngle(0);
		setRadius(0);
	}
	
	//accessors
	public boolean isAlive() {return isAlive;}
	public double getRadius() {return radius;}
	public double getX() {return x;}
	public double getY() {return y;}
	public double getVelX() {return velX;}
	public double getVelY() {return velY;}
	public int getWidth() {return (int)(radius * 2);}
	public double getMoveAngle() {return moveAngle;}
	
	//mutators
	public void setAlive(boolean b) {isAlive = b;}
	public void setRadius(double r) {radius = r;}
	public void setX(double x) {this.x = x;}
	public void addToX(double i) {x += i;}
	public void setY(double y) {this.y = y;}
	public void addToY(double i) {y += i;}
	public void setVelX(double velX) {this.velX = velX;}
	public void addToVelX(double i) {velX += i;}
	public void setVelY(double velY) {this.velY = velY;}
	public void addToVelY(double i) {velY += i;}
	public void setMoveAngle(double moveAngle) {this.moveAngle = moveAngle;}
	public void addToMoveAngle(double i) {moveAngle += i;}
	
	public boolean collidesWith(Point2D p) {
		double delX = p.getX() - getX();
		double delY = p.getY() - getY();
		double dist = Math.sqrt(delX * delX + delY*delY);
		return dist < getRadius();
	}
	public boolean collidesWith(GameObject obj) {
		double delX = obj.getX() - getX();
		double delY = obj.getY() - getY();
		double dist = Math.sqrt(delX * delX + delY*delY);
		return dist < obj.getRadius() + getRadius();
	}
	public boolean collidesWith(Rectangle r) {
		return x + radius > r.getX() && x - radius < r.getX() + r.getWidth()
				&& y + radius > r.getY() && y - radius < r.getY() + r.getHeight();
	}

}
