package CharacterGenerator;

import java.io.IOException;

public class CharacterGeneratorRunner {

    public static void main(String[] args) throws IOException {
        int numRun = 5;
        for (int i = 0; i < numRun; i++) {
            System.out.println("Creating image " + (i+1) + "...");
            Character.createCharacter();
            System.out.println("Image " + (i+1) + " created!" + "\n" + "located in GeneratedArt\\" + Character.getFileName());
        }
        //Character.createCharacter();
    } 
}
