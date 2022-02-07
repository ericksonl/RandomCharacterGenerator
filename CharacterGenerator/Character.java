package CharacterGenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Random;

import javax.imageio.ImageIO;

public class Character extends RareCalc {

    private static String fileName;
    /*To be Reviewed (TBR): private static double skinPercent;
    private static double mouthPercent;
    private static double shirtPercent;
    private static double conePercent;
    private static double eyesPercent;*/

    private static String cPath = "RandomCharacterGenerator/CharacterGenerator/GeneratedArt/";

    public static String getFileName () {return fileName;}
    
    private static void deleteTemp () {
        Path path = FileSystems.getDefault().getPath(cPath + "/Temp.png");
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("No such file or directory - ", path);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    
    private static void writeImage(BufferedImage img) throws IOException { 
        fileName = fileName + ".png";
        //TBR: fileName = fileName + "Rarity=" + rarePercent + ".png";
        File f = new File(cPath + fileName);
        if (f.exists()) {
            System.out.println(fileName + " has already been generated! Trying again...");
            createCharacter();
        } else {
            ImageIO.write(img, "png", new File(cPath + fileName));    
        }
    }
    
    private static File fileHelper (File fileIn) {
        File[] fileInFiles = fileIn.listFiles(); //created an array of the files in the specified folder
        Random rand = new Random(); //random 
        File returnFile = fileInFiles[rand.nextInt(fileInFiles.length)]; //randomly selects file 
        
        return returnFile;
    }

    private static File selectBackground () throws IOException {
        File background = fileHelper(new File("RandomCharacterGenerator/CharacterGenerator/BodyParts/Backgrounds/"));  //select the background folder director
        return selectSkin(background);
    }

    private static File selectSkin (File background) throws IOException {

        File skin = fileHelper(new File(rareChance() + "Skins/"));  //select the skins Folder
        //TBR: skinPercent *= rChecker("Skins/");

        fileName += skin.getName();
        fileName = fileName.substring(0, fileName.length()-3);
        return selectShirt(mergeParts(background, skin));
    }

    private static File selectShirt (File skin) throws IOException {
        File shirt = fileHelper(new File(rareChance() + "Shirts"));  //select the Body folder director
        //TBR: shirtPercent *= rChecker("Shirts/");

        fileName += shirt.getName(); 
        fileName = fileName.substring(0, fileName.length()-3);
        return selectMouth(mergeParts(skin, shirt));
    }


    private static File selectMouth (File skin) throws IOException {
        File mouth = fileHelper(new File(rareChance() + "Mouths"));  //select the mouth Folder
        //TBR: mouthPercent *= rChecker("Mouths/");

        fileName += mouth.getName(); 
        fileName = fileName.substring(0, fileName.length()-3);
        return selectEyes(mergeParts(skin, mouth));
        //return mergeParts(rArm, body);
    }
    

    private static File selectEyes (File mouth) throws IOException {
        File eyes = fileHelper(new File (rareChance() + "Eyes/")); //select the eyes folder director
        //TBR: eyesPercent *= rChecker("Eyes/");

        fileName += eyes.getName(); 
        fileName = fileName.substring(0, fileName.length()-3);
        return selectCone(mergeParts(mouth, eyes));
    }

    private static File selectCone (File eyes) throws IOException {
        File cone = fileHelper(new File(rareChance() + "Cones/"));  //select the Cone folder director
        //TBR: conePercent *= rChecker("Cones/");

        fileName += cone.getName(); 
        fileName = fileName.substring(0, fileName.length()-3);
        return mergeParts(eyes, cone);
    }

    public static void createCharacter () throws IOException {
        fileName = ""; //resets fileName for multiple iterations
        FileInputStream fis = new FileInputStream(selectBackground()); 
        //TBR: calls on select Background to begin character creation and converts the return into a filestream

        BufferedImage img = ImageIO.read(fis); //creates a new bufferedImage from fis
        fis.close(); //IMPORTANT TO CLOSE FIS FOR TEMP DELETION

        writeImage(img); //writes the new image to disk
        Character.deleteTemp(); //deletes temporary png file
    }
}
