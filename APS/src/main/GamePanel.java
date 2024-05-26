package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import obj.DiscardGlass;
import obj.Trash;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize = 64; 
	final int scale = 1;
	public final int tileSize = originalTileSize * scale; 
	
	public final int maxScreenCol = 15;
	public final int maxScreenRow = 8;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	public final int maxWorldCol = 47;
	public final int maxWorldRow = 34;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public Collision checker = new Collision(this);
	public InitObject initObject = new InitObject(this);
	public SetDiscardObject objSetter = new SetDiscardObject(this);
	public Player player = new Player(this, keyH);
	public ArrayList<Trash> objects = new ArrayList<Trash>();
	public Trash discard[] = new Trash[6];
	
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	public int[] gameTime = {3, 0};
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.addKeyListener(keyH);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
		gameState = playState;
		objSetter.setObject();
		System.out.printf("%s:0%s%n", gameTime[0], gameTime[1]);
		
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		System.out.println();
	}
	
	@Override
	public void run() {

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		int secondsPassed = 0;
		long timer = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
			update();
			repaint();
			delta--;
			}
			
			if(timer >= 1000000000) {
				secondsPassed ++;
				gameTime[1] --;
				if(gameTime[1] < 0) {
					gameTime[1] = 59;
					gameTime[0] --;
				}
				if(gameTime[1] < 10) { System.out.printf("%s:0%s%n", gameTime[0], gameTime[1]); }
				else { System.out.printf("%s:%s%n", gameTime[0], gameTime[1]); }
				if(gameTime[0] < 1 && gameTime[1] < 1) { while(true){} }
				timer = 0;
			}
			
			if(secondsPassed >= 4) {
				objects.add(initObject.newObj());
				secondsPassed = 0;
			}
		}
		
	}
	
	
	public void update() {
		
		if(gameState == playState) {
			player.update();	
		}
		if(gameState == pauseState) {
			//nothing
		}
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).draw(g2, this);
		}
		
		for(int i = 0; i < discard.length; i++) {
			
			if(discard[i] != null) {
				discard[i].draw(g2, this);
			}
		}
		
		player.draw(g2);
		
		g2.dispose();
	}


}
