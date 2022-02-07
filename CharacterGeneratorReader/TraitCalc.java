package CharacterGeneratorReader;

import java.io.File;

public class TraitCalc {
    
    //each array contains the name of a specifit part
    //Ex: skinRarities is an array of all skins, e.g MilkChocolate
    private static String[] skinRarities = {"MilkChocolate", "Strawberry", "Gold", "Nebula", "Shadow", "Abstract", "Neapolitan", "WoodCamo", 
                                            "Banana", "Blueberry", "OrangeDream", "SpeckledStrawberry"};

    private static String[] shirtRarities = {"BlankShirt", "DBBEater", "GreyBeater", "GreenBeater", "ClownSuitB&W", "ClownSuitYellow", "GoldRobe", 
                                            "Pimp", "BowTieSuit", "ClownSuitBlue", "LifeVest", "TieSuit", "DBTee", "GreenTee", "PinkTee", };

    private static String[] mouthRarities = {"Closed", "Grin", "GoldToothZombie", "GrinGold", "Gaping", "RainbowMouth", "UwU", "ClosedCigarrette", "Zombie", };

    private static String[] eyesRarities = {"Goopy", "BigLaser", "Big", "Eyeglasses", "RainbowEyes", };

    private static String[] conesRarities = {"BlankCone", "Chocolate", "Plain", "Halo", "Milkshake", "Party", "Cake", "DippedChocolate", "DippedPlain", 
                                            "BrokenChocolate", "BrokenPlain", };

    //Looks in a direct (CharacterGenerator/GeneratedArt)
    
    public static void numFileCalc () {
        File f = new File("CharacterGenerator/GeneratedArt");
        File[] files = f.listFiles(); //creates an array of all the art in /GeneratedArt
        int numFiles = files.length;
        String part;
        int iend1, iend2, iend3, iend4, iend5;
   
        String[] skins = new String[numFiles]; 
        String[] shirts = new String[numFiles]; 
        String[] mouths = new String[numFiles];
        String[] eyes = new String[numFiles];
        String[] cones = new String[numFiles];
    
        for (int i = 0; i < numFiles; i++) {
            part = files[i].getName();
            iend1 = part.indexOf(".");
            iend2 = part.indexOf(".", iend1 + 1);
            iend3 = part.indexOf(".", iend2 + 1);
            iend4 = part.indexOf(".", iend3 + 1);
            iend5 = part.indexOf(".", iend4 + 1);
    
            skins[i] = part.substring(0, iend1);
            shirts[i] = part.substring(iend1+1, iend2);
            mouths[i] = part.substring(iend2+1, iend3);
            eyes[i] = part.substring(iend3+1, iend4);
            cones[i] = part.substring(iend4+1, iend5);
        }

        System.out.print("Skins: ");
        answerQueries(skins, skinRarities);

        System.out.print("Shirts: ");
        answerQueries(shirts, shirtRarities);

        System.out.print("Mouths: ");
        answerQueries(mouths, mouthRarities);

        System.out.print("Eyes: ");
        answerQueries(eyes, eyesRarities);
        
        System.out.print("Cones: ");
        answerQueries(cones, conesRarities);

    }

    //takes an array and string on one array to compare
    //looks at every element in arr and compares it to String s
    //if a String ∈ arr .equals String s, increment counter
    //return the counter
    private static int search(String[]arr, String s) {
        int counter = 0;
        for (int j = 0; j < arr.length; j++)
            if (s.equals(arr[j])) {
                counter++;
            }
        return counter;
    }
    
    //takes in two arrays, then loops through q
    //takes on element of q and compares it to every element in arr using the search() method
    private static void answerQueries(String[] arr, String q[]) {
        for (int i=0;i<q.length; i++) {
            System.out.print("\n    " + q[i] + " = " + search(arr, q[i]) + "   ");
        }
        System.out.println("\n");
    }
}

