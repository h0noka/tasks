	import java.io.File;

public class CvMain {
	
	static void imageProcessing1(String filename1, String filename2, String filename3, double a, int x1, int y1, int x2, int y2, int flag) {

		MyImage image1, image2, image3, image4, image0;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		
		image4 = Scale.execute(image1, a, a);
		
		if(flag == 0){
			image2 = Scale.execute(image2, 0.48648, 0.48648);
		}
		else if(flag == 1){
			image2 = Scale.execute(image2, 0.48648, 0.48648);
			image2 = Rotation.execute(image2);
		}
		
		
		KMeans kmeans = new KMeans();
		kmeans.clustering(image2, 6);
		image0 = Chromakey.execute(image2, kmeans, 3);
		
		image4 = Trimming.execute(image2, image4, image0, x1, y1); 
		image4 = Setting.execute(image3, image4, image0, x2, y2); 
		
		JpegFileWriter.write(filename3, image4);
		
	}
	
	
	static void imageProcessing2(String filename1, String filename2, int x1, int y1, int z1, int x2, int y2, int flag) {

		MyImage image1, image2, image0, image3;
		
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		
		if(flag == 0){
			image1 = Scale.execute(image1, 0.48648, 0.48648);
		}
		else if(flag == 1){
			image1 = Scale.execute(image1, 0.48648, 0.48648);
			image1 = Rotation.execute(image1);
		}
		
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 6);
		image0 = Chromakey.execute(image1, kmeans, 3);
		
		image1 = MakeHeart.execute(image0, x1, y1, z1);
		image3 = Setting.execute(image2, image1, image0, x2, y2); 
		
		JpegFileWriter.write(filename2, image3);
		
	}
	
	static void imageProcessing0(String filename1) {
	
		MyImage image1;
		image1 = MakeImage.execute();
		
		JpegFileWriter.write(filename1, image1);
	}


	public static void main(String args[]) {
	
	imageProcessing0("image.jpg");
	imageProcessing1("image1.jpg", "heart.png", "image.jpg", 0.075, 70, 0, 10, 20,0);
	imageProcessing1("image2.jpg", "heart.png", "image.jpg",  0.12, 5, 100, 240, 20,0);
	imageProcessing2("heart.png", "image.jpg", 255, 255, 255, 470,20,0);
	imageProcessing1("image4.jpg", "heart.png", "image.jpg", 0.095, 85, 30, 700, 20,0);
	imageProcessing1("image5.jpg", "heart.png", "image.jpg", 0.9, 240, 80, 930, 20,0);
	imageProcessing1("image6.jpg", "heart.png", "image.jpg", 0.5, 870, 0, -105, 170 ,1);
	imageProcessing2("heart.png", "image.jpg", 226, 47, 170, 125, 170 ,1);
	imageProcessing1("image8.jpg", "heart.png", "image.jpg", 0.08, 60, 0, 355, 170 ,1);
	imageProcessing1("image9.jpg", "heart.png", "image.jpg", 0.15, 90, 0, 605, 175 ,2);
	imageProcessing1("image10.jpg", "heart.png", "image.jpg", 0.25, 55, 5, 10,370, 0);
	imageProcessing1("image11.jpg", "heart.png", "image.jpg", 0.081, 75, -1, 240, 370, 0);
	imageProcessing1("image12.jpg", "heart.png", "image.jpg", 0.1, 190, 35, 470, 370, 0);
	imageProcessing1("image13.jpg", "heart.png", "image.jpg", 0.08, 30, 5, 930, 370, 0);
	imageProcessing1("image14.jpg", "heart.png", "image.jpg", 1, 400, 150, -105, 510, 1);
	imageProcessing1("image15.jpg", "heart.png", "image.jpg", 0.075, 5, 0, 125, 520, 1);
	imageProcessing1("image16.jpg", "heart.png", "image.jpg", 0.7, 193, 40, 355, 520, 1);
	imageProcessing1("image17.jpg", "heart.png", "image.jpg", 0.15, 300, 63, 585, 520, 1);
	imageProcessing2("heart.png", "image.jpg", 255, 255, 255, 800, 520 ,1);
	}
}