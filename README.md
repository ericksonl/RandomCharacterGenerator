# RandomCharacterGenerator

## About

Random Character Generator is a program that allows you to generate unique characters by randomly combining different body parts. The program selects images for the background, skin, shirt, mouth, eyes, and cone from an array of images. Each body part is overlaid to create a distinctive character. The generator supports multiple rarities for each body part, including common, uncommon, rare, and legendary.

I also recreated this project using JavaScript which you can see on [my website](https://www.liamedev.com/code/RCG/)

## How to use

1. Download all the associated files.
2. Replace the images in the /BodyParts directory with your own drawings. Make sure all images have the same pixel width and height to avoid overlay issues.
3. Run the program using CharacterGeneratorRunner.java.
4. Customize the number of times the program runs by changing the value of numRun in the CharacterGeneratorRunner.java file.
5. Experiment with different values to achieve the desired result.

**Important:** When replacing images with your own, make sure every image is the same pixel width x height. If not, this could cause issues, such as overlays not working properly.

## How it works

* The CharacterGenerator class randomly selects and overlays body part images to create characters.
* The order of overlaying is as follows: background, skin, shirt, mouth, eyes, and cone.
* Each body part has four rarities: common, uncommon, rare, and legendary.
* The rarity of a body part is determined by a weighted random selection, which can be adjusted in the RareCalc.java file.
* The CharacterGeneratorReader class reads the generated art files in the GeneratedArt/ directory and provides a count of each body part, allowing you to determine the rarity of the generated characters.

Note: The program uses a temporary file (temp.png) to facilitate overlaying body parts. Multiple iterations of the program are allowed as the temporary file is deleted after each new character is generated.

