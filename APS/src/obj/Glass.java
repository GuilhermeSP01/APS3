package obj;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Glass extends Trash{

	public Glass(int xPos, int yPos) {

		Random random = new Random();
		int n = random.nextInt(3);
		
		x = xPos;
		y = yPos;
		type = "Glass";
		try { 
			switch(n) {
			case 0:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/glass1.png"));
				break;
			case 1:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/glass2.png"));
				break;
			case 2:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/glass3.png"));
				break;
		} 
		} catch(IOException e) { e.printStackTrace(); }
		
	}

}
