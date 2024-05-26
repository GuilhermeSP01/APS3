package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DiscardPaper extends Trash{
	
	public DiscardPaper() {
		
		type = "dOrganic";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/t5.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
