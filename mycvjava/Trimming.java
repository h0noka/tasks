
import java.awt.*;


public class Trimming {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0, int x, int y) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = input1.width;
		int height = input1.height;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
				
					Color color0 = input0.getColor(j, i);
					if(color0.getRed() < 255) {

						Color color1 = new Color(229, 190, 253);
						output.setColor(j, i, color1);
						isProcessed = true;
					
					}
					if(isProcessed == false) {
						Color color1 = input2.getColor(j+x, i+y);
						output.setColor(j, i, color1);
				}
			}
		}

		return output;

	}

}
