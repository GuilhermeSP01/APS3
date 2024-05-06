package obj;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Plastic extends Trash{

	public Plastic(int xPos, int yPos) {
		
		Random random = new Random();
		int n = random.nextInt(4);
		
		x = xPos;
		y = yPos;
		type = "Plastic";
		try { 
			switch(n) {
			case 0:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/plastic1.png"));
				break;
			case 1:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/plastic2.png"));
				break;
			case 2:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/plastic3.png"));
				break;
			case 3:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/plastic4.png"));
				break;
			} 
		} catch(IOException e) { e.printStackTrace(); }
		
	}

}
