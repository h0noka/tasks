
import java.awt.*;


public class MakeHeart {

	static MyImage execute(MyImage input1, int x, int y, int z) { 

		int width  = input1.width;
		int height = input1.height;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
				
					Color color0 = input1.getColor(j, i);
					if(color0.getRed() < 255) {
					Color color1 = new Color(229, 190, 253);
						output.setColor(j, i, color1);
						isProcessed = true;
					
					}
					if(isProcessed == false) {
						Color color1 = new Color(x, y, z);
						output.setColor(j, i, color1);
				}
			}
		}

		return output;

	}

}
