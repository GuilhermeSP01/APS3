package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import element.Element;

public class Player extends Element {

	GamePanel gp;
	KeyHandler keyH;
	public BufferedImage sprite, Up, UpR, UpR2, UpR3, UpL, UpL2, UpL3, Down, DownR, DownR2, DownR3, DownL, DownL2, DownL3, Right, Left;
	
	public int x;
	public int y;
	public int screenX;
	public int screenY;
	int speed = 0;
	int maxSpeed = 5;
	int direction = 0;
	int timer = 0;
	int timerLimit = 9;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		this.x = gp.tileSize * 12;
		this.y = gp.tileSize * 6;
		
		this.screenX = gp.screenWidth/2 - (gp.tileSize/2);
		this.screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 22;
		solidArea.y = 22;
		solidArea.width = 20;
		solidArea.height = 20;
		
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		try {
			
			sprite = ImageIO.read(getClass().getResourceAsStream("/player/truck120.png"));
			Up = ImageIO.read(getClass().getResourceAsStream("/player/truck120U.png"));
			UpR3 = ImageIO.read(getClass().getResourceAsStream("/player/truck120UR3.png"));
			UpR = ImageIO.read(getClass().getResourceAsStream("/player/truck120UR.png"));
			UpR2 = ImageIO.read(getClass().getResourceAsStream("/player/truck120UR2.png"));
			UpL3 = ImageIO.read(getClass().getResourceAsStream("/player/truck120UL3.png"));
			UpL = ImageIO.read(getClass().getResourceAsStream("/player/truck120UL.png"));
			UpL2 = ImageIO.read(getClass().getResourceAsStream("/player/truck120UL2.png"));
			Down = ImageIO.read(getClass().getResourceAsStream("/player/truck120D.png"));
			DownR3 = ImageIO.read(getClass().getResourceAsStream("/player/truck120DR3.png"));
			DownR = ImageIO.read(getClass().getResourceAsStream("/player/truck120DR.png"));
			DownR2 = ImageIO.read(getClass().getResourceAsStream("/player/truck120DR2.png"));
			DownL3 = ImageIO.read(getClass().getResourceAsStream("/player/truck120DL3.png"));
			DownL = ImageIO.read(getClass().getResourceAsStream("/player/truck120DL.png"));
			DownL2 = ImageIO.read(getClass().getResourceAsStream("/player/truck120DL2.png"));
			Right = ImageIO.read(getClass().getResourceAsStream("/player/truck120R.png"));
			Left = ImageIO.read(getClass().getResourceAsStream("/player/truck120L.png"));			
			
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void update() {
				
		if((keyH.upPressed || keyH.downPressed) && !(keyH.leftPressed || keyH.rightPressed)) {
			if(keyH.upPressed && !keyH.downPressed) { direction = 0; }
			if(keyH.downPressed && !keyH.upPressed) { direction = 8; }
		} else if(!(keyH.upPressed || keyH.downPressed) && (keyH.leftPressed || keyH.rightPressed)) {
			if(keyH.leftPressed && !keyH.rightPressed) { direction = 12; }
			if(keyH.rightPressed && !keyH.leftPressed) { direction = 4; }
		}
		
		if((keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) && speed < maxSpeed) { speed++; } 
		else if(!(speed <= 0)){ speed--; }
		
		collisionOn = false;
		gp.checker.checkTile(this);
		
		if(collisionOn == false) {
		
			switch(direction) {
				case 0:
					y -= speed;
					break;
				case 4:
					x += speed;
					break;
				case 8:
					y += speed;
					break;
				case 12:
					x -= speed;
					break;
			}
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		if(direction == 0) { sprite = Up; }
		if(direction == 1) { sprite = UpR3; }
		if(direction == 2) { sprite = UpR; }
		if(direction == 3) { sprite = UpR2; }
		if(direction == 4) { sprite = Right; }
		if(direction == 5) { sprite = DownR2; }
		if(direction == 6) { sprite = DownR; }
		if(direction == 7) { sprite = DownR3; }
		if(direction == 8) { sprite = Down; }
		if(direction == 9) { sprite = DownL3; }
		if(direction == 10) { sprite = DownL; }
		if(direction == 11) { sprite = DownL2; }
		if(direction == 12) { sprite = Left; }
		if(direction == 13) { sprite = UpL2; }
		if(direction == 14) { sprite = UpL; }
		if(direction == 15) { sprite = UpL3; }
		
		g2.drawImage(sprite, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
