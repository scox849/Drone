import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Author Sam Cox
 */
public class Camera {

    int imgCnt = 0; // Count of images taken.
    final int imgLimit = 3; // Storage Limit


    /**
     * Captures image. For simulation creates an image of random pixels.
     */
    public void captureImage(){
        int width = 1920;
        int height = 1080;
        BufferedImage image = new BufferedImage(width,
                height,BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                int a = (int) (Math.random()*256);
                int r = (int) (Math.random()*256);
                int g = (int) (Math.random()*256);
                int b = (int) (Math.random()*256);

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(i,j,p);
            }
        }

        if(this.storeImage(image)){
            System.out.println("Image stored successfully.");
        }else{
            System.out.println("Unable to store image: storage full.");
        }
    }

    /**
     * Stores the image taken.
     * @param image image from camera
     * @return true false
     */
    public boolean storeImage(BufferedImage image){
        File imageFile;
        try{
            if(imgCnt < imgLimit){
                imageFile = new File( imgCnt + ".png");
                ImageIO.write(image, "png", imageFile);
                imgCnt++;
                return true;
            }
        }catch (IOException e){
            System.out.println("Error :");
        }
        return false;
    }

}
