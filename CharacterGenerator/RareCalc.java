package CharacterGenerator;

//import java.io.File;
import java.util.Random;

public class RareCalc extends Merge{
    
    //To be Reviewed (TBR): public static double totalRare;

    //TBR: private static double percentLegend = 0.05, percentRare = 0.15, percentUncommon = 0.30, percentCommon = 0.50;
    

    //Generates a random number to determine rarity. 5% Legendary, 15% rare, 30%Uncommon, 50% common. Can be changed
    //Returns the file depending on rarity
    //File returned: "CharacterGenerator/BodyParts/<rarity>"
    public static String rareChance () { 
        Random rand = new Random();
        int rareChance = (rand.nextInt(100));  //generate random # 0-99
        StringBuilder rFolder = new StringBuilder("CharacterGenerator/BodyParts/"); 
        rarity = "";//resets rarity

        if (rareChance <= 49) {
            rarity = "Common/"; //sets rarity to Common/
            rFolder = rFolder.append(rarity);
        } else if (rareChance <= 79) {
            rarity = "Uncommon/"; //sets rarity to Uncommon/
            rFolder = rFolder.append(rarity);
        } else if (rareChance <= 94) {
            rarity = "Rare/"; //sets rarity to Rare/
            rFolder = rFolder.append(rarity);
        } else {
            rarity = "Legendary/"; //sets rarity to Legendary/
            rFolder = rFolder.append(rarity);
        }

        return rFolder.toString(); //return the folder to look in
    }
}

    /*TBR: 
    //given a body part, reads the file based on the body part and rarity to return # of files in folder
    //Ex: partType = Skins, rarity = Rare
        //returns # files in "CharacterGenerator/BodyParts/Rare/Skins/"
    public static double rChecker(String partType) {
        File f = new File("CharacterGenerator/BodyParts/" + rarity + partType); //new file based on rarity + partType
        File[] files = f.listFiles(); //creates array of files in ^ string
        return rarityCalc(files.length); //returns length of files array
    }


    //given numItems, calculates total rarity
    //Ex: numItems = 5, rarity = Rare/
        //totalRare =  .15*(1/5) = .15*.2 = .003 = .3% chance to have that rare trait.
    private static double rarityCalc (double numItems) {
        
        if (rarity == "Legendary/") {
            totalRare = percentLegend*(1/numItems); 
        } else if (rarity == "Rare/") {
            totalRare = percentRare*(1/numItems);
        } else if (rarity == "Uncommon/") {
            totalRare = percentUncommon*(1/numItems);
        } else {
            totalRare = percentCommon*(1/numItems);
        }

        return totalRare;
    }*/

