package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{

	keyHandler keyH = new keyHandler();
	Thread gameThread;
	
	int playerX = 200;
	int playerY = 300;
	int playerSpeed = 4;
	
	public Game() {
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		while(gameThread != null) {
			double drawInterval = 1000000000/60;
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
				
			while(gameThread != null) {
					
				currentTime = System.nanoTime();
				delta += (currentTime - lastTime) / drawInterval;
				lastTime = currentTime;
					
				if(delta >= 1) {
				update();
				repaint();
				delta--;
				}
			}
		}
	}
	
	public void update() {
		if(keyH.upPressed == true) { playerY -= playerSpeed; }
		if(keyH.downPressed == true) { playerY += playerSpeed; }
		if(keyH.leftPressed == true) { playerX -= playerSpeed; }
		if(keyH.rightPressed == true) { playerX += playerSpeed; }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, 64, 64);
		
		g2.dispose();
	}
	
}
