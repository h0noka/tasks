
import java.awt.*;


public class MakeImage {

	static MyImage execute() { 

		int width  = 1024;
		int height = 614;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(i % 160 > 120 || j % 160 > 120){
					Color color1 = new Color(240, 200, 255);
					output.setColor(j, i, color1);
				}
				else{
					Color color1 = new Color(229, 190, 253);
					output.setColor(j, i, color1);
				}
				}
			}
		return output;
	}
}