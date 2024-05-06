package main;

import java.util.Random;

import obj.Glass;
import obj.Organic;
import obj.Paper;
import obj.Plastic;
import obj.Trash;

public class InitObject {

	GamePanel gp;
	
	public InitObject(GamePanel gp) {
		this.gp = gp;
	}

	public Trash newObj() {
		Random random = new Random();
		int n = random.nextInt(4);
		
		switch(n) {
		case 0:
			return new Plastic(gp.tileSize * 12, gp.tileSize * 4);
		case 1:
			return new Paper(gp.tileSize * 12, gp.tileSize * 4);
		case 2:
			return new Organic(gp.tileSize * 12, gp.tileSize * 4);
		case 3:
			return new Glass(gp.tileSize * 12, gp.tileSize * 4);
		}
		
		return new Trash();
		
	}
}
