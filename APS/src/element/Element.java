package element;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Element {
	
	public int x, y;
	public int speed;
	public BufferedImage sprite, Up, Down, Right, Left;
	
	public int direction;
	public Rectangle solidArea;
	public boolean collisionOn = false;

}
