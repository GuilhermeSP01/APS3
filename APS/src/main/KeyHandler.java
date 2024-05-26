package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, mPressed, iPressed;
	
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		//PLAY STATE		
		if(gp.gameState == gp.playState) {
			
			if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				upPressed = true;
			}
			
			if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			
			if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				downPressed = true;
			}
			
			if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			
			if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_SPACE) {
				spacePressed = true;
			}
			
			if(code == KeyEvent.VK_M || code == KeyEvent.VK_M) {
				mPressed = true;
			}	
			
			if(code == KeyEvent.VK_I || code == KeyEvent.VK_I) {
				gp.gameState = gp.pauseState;
			}		
			
		}
			
		//PAUSE OR INVENTORY STATE
		else if(gp.gameState == gp.pauseState) {
			
			if(code == KeyEvent.VK_I || code == KeyEvent.VK_I) {
					gp.gameState = gp.playState;
			}
					
			if(code == KeyEvent.VK_W) {
				if(gp.player.slotRow != 0) {
					gp.player.slotRow--;
				}
			}
			
			if(code == KeyEvent.VK_A) {
				if(gp.player.slotCol != 0) {
					gp.player.slotCol--;
				}
			}
			
			if(code == KeyEvent.VK_S) {
				if(gp.player.slotRow != 1) {
					gp.player.slotRow++;
				}
			}
			
			if(code == KeyEvent.VK_D) {
				if(gp.player.slotCol != 2) {
					gp.player.slotCol++;
				}
			}
			
			if(gp.player.onDiscard) {
				if(code == KeyEvent.VK_ENTER) {
					if((gp.player.inventory.size() > 0) && (gp.player.inventory.size() - 1 >= gp.player.slotRow*3 + gp.player.slotCol)) {
						if(gp.player.inventory.get(gp.player.slotRow*3 + gp.player.slotCol).type.equals(gp.player.discardPoint)) {
							System.out.println("Tipo correspondente, +10 pontos");
							gp.player.score += 10;
						} else {
							System.out.println("Tipo diferente, -10 pontos");
							gp.player.score -= 10;
						}
						gp.player.inventory.remove(gp.player.slotRow*3 + gp.player.slotCol);
						System.out.printf("Pontuação: %s %n", gp.player.score);
					}
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		
		if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_SPACE) {
			spacePressed = false;
		}
		
		if(code == KeyEvent.VK_M || code == KeyEvent.VK_M) {
			mPressed = false;
		}
				
	}
	
}
