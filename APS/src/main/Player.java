package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import element.Element;
import obj.Glass;

public class Player extends Element  {

	GamePanel gp;
	KeyHandler keyH;
	Graphics2D g2;
	Glass glass;
	
	public BufferedImage sprite, Up, Down, Right, Left;
	public ArrayList<Player> inventory = new ArrayList<>();
	public final int maxInventorySize = 6;
	
	public int x;
	public int y;
	public int screenX;
	public int screenY;
	int speed = 0;
	int maxSpeed = 5;
	int direction = 0;
	
	public int slotCol = 0;
	public int slotRow = 0;
	
	public boolean test = true;
	
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
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 20;
		solidArea.height = 20;
		
		getPlayerImage();
		//setItems();
	}
	
	public void getPlayerImage() {
		try {
			
			sprite = ImageIO.read(getClass().getResourceAsStream("/player/truck120.png"));
			Up = ImageIO.read(getClass().getResourceAsStream("/player/truck120U.png"));
			Down = ImageIO.read(getClass().getResourceAsStream("/player/truck120D.png"));
			Right = ImageIO.read(getClass().getResourceAsStream("/player/truck120R.png"));
			Left = ImageIO.read(getClass().getResourceAsStream("/player/truck120L.png"));			
			
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void update() {
		
		if(keyH.spacePressed && test) {
			gp.objects.add(gp.initObject.newObj());
			test = false;
		}
				
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
		
		collectObject(gp.checker.checkObject(this, true));
		
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
	
	public void collectObject(int index) {
		
		if(index != 999) {
			
				this.test = true;
				
				switch(gp.objects.get(index).type) {
				case "Plastic":
					System.out.println("COLETOU PLÁSTICO");// VC PROVAVELMENTE VAI USAR ESSAS LINHAS
					gp.objects.remove(index);
					break;
				case "Glass":
					System.out.println("COLETOU VIDRO");// VC PROVAVELMENTE VAI USAR ESSAS LINHAS
					gp.objects.remove(index);
					break;
				case "Paper":
					System.out.println("COLETOU PAPEL");// VC PROVAVELMENTE VAI USAR ESSAS LINHAS
					gp.objects.remove(index);
					break;
				case "Organic":
					System.out.println("COLETOU ORGÂNICO");// VC PROVAVELMENTE VAI USAR ESSAS LINHAS
					gp.objects.remove(index);
					break;
			
			}
			
		}
		
	}
	
	/*public void setItems() {
		
		inventory.add();
	}*/
	
	public void drawInventory() {
		
		int frameX = gp.tileSize*2;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize*4;
		int frameHeight = gp.tileSize*3;
		
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		final int slotXstart = frameX + 30;
		final int slotYstart = frameY + 30;
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSize = gp.tileSize+3;
		
		/*for(int i = 0; i < gp.player.inventory.size(); i++) {
			
			g2.drawImage(gp.player.inventory.get(i)., slotX, slotY, null);
		}*/
		
		int cursorX = slotXstart + (slotSize * slotCol);
		int cursorY = slotYstart + (slotSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0, 0, 0, 100);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 25, 25);
		
		c = new Color(255, 255, 255);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 15, 15);
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		if (gp.gameState == gp.pauseState) {
				drawInventory();
		}
		
		if(direction == 0) { sprite = Up; }
		if(direction == 4) { sprite = Right; }
		if(direction == 8) { sprite = Down; }
		if(direction == 12) { sprite = Left; }
		
		g2.drawImage(sprite, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
