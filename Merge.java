package CharacterGenerator;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Merge {

    //To be Reviewed (TBR): private static double rarePercent;
    public static String rarity; 

    //takes in two files (images) and merges them together by pasting one over the other
    //To work effectively, images should be drawn where they should be pasted
    public static File mergeParts (File part1, File part2) throws IOException {
        //create two buffered images from given files
        BufferedImage Bpart1 = ImageIO.read(part1);
        BufferedImage Bbody = ImageIO.read(part2);
     
        // create the new image
        int w = Math.max(Bpart1.getWidth(), Bbody.getWidth());
        int h = Math.max(Bpart1.getHeight(), Bbody.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
     
        // combine images
        Graphics g = combined.getGraphics();
        g.drawImage(Bpart1, 0, 0, null);
        g.drawImage(Bbody, 0, 0, null);
     
        g.dispose();

        return tempImage(combined);
    }

    //TBR: creates a temporary image to store while images are being merged
    //so that write image does not have to be called repeatedly 
    private static File tempImage(BufferedImage img) throws IOException {
        //convert bufferedimage img to a file 
        ImageIO.write(img, "png", new File("CharacterGenerator/GeneratedArt/Temp.png"));
        File tempImg = new File("CharacterGenerator/GeneratedArt/Temp.png");
        
        //return the new file
        return tempImg;
    }
}