package CharacterGenerator;

import java.io.IOException;

public class CharacterGeneratorRunner {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Creating image " + (i+1) + "...");
            Character.createCharacter();
            System.out.println("Image " + (i+1) + " created!" + "\n" + "located in C:\\UsersLiam\\Desktop\\Files\\Code\\CharacterGenerator\\GeneratedArt\\" + Character.getFileName());
        }
        //Character.createCharacter();
    } 
}
