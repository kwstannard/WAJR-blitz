package app;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import models.Sprite;



abstract public class Game extends Applet implements KeyListener, Runnable {
	abstract public void keyDown(int keyCode, int keyLocation);
	abstract public void keyUp(int keyCode, int keyLocation);
	
	private Thread gameLoop;
	
	private LinkedList <Sprite> sprites;
	public LinkedList <Sprite> getSprites() {return sprites}
	
	private BufferedImage buffer;
	private Graphics2D g2d;
	
	
	public void keyPressed(KeyEvent e) {
		keyDown(e.getKeyCode(), e.getKeyLocation());
	}

	public void keyReleased(KeyEvent e) {
		keyUp(e.getKeyCode(), e.getKeyLocation());
	}

	public void keyTyped(KeyEvent e) {}

	public void run() {
		
	}
	
}
