package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DiscardPlastic extends Trash {
	
	public DiscardPlastic() {
		
		type = "Plastic";
		/*try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/t5.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		collision = true;
	}
}
