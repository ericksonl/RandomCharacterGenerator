# RandomCharacterGenerator

## How to use
To use the Character Generator, download all associating files. You can replace every image used in /BodyParts with your own drawings. You may then run the program using CharacterGeneratorRunner.java. Replacing `int numRun;` with a integer, x, will cause the program to run x amount of times.

Feel free to play with any value to properly fit your needs. 

Documentation below

**Important:** When replacing images with your own, make sure every image is the same pixel width x height. If not, this could cause issues, such as overlays not working properly.

## How it works
### CharacterGenerator 
works by randomly choosing an body part image from an array of images. It then will overlay each image. The following is the order at which images are placed

1. Background
2. Skin
3. Shirt
4. Mouth
5. Eyes
6. Cone

Each category has 4 rarities: Common, Uncommon, Rare and Legendary. <br> Once a body part type is selected, i.e Eyes, a weighted random rarity will be assigned. There is a 50% chance to get common eyes, 30% chance to get uncommon, 15% chance for rare, and 5% chance for Legendary. These can be changed directly in the "RareCalc.java" file. <br>
`rareChance <= x`, 
<br>x is what you need to change. A random number 0-99 is selected, so rarity is based on that. 
<br> I.e, `rareChance <= 49` gives you a 50% chance, as any number 0-49 might be generated. 

Between each body part selection, a temp.png file is created that the next body part type works off of. It is overlayed onto the temp.png. Once all types have been selected and overlayed on temp.png, the program will create a new .png, with the naming convention<br>
**[background].[skin].[shirt].[mouth].[eyes].[cone]..png**
<br> The "." after each type is important for the CharacterGeneratorReader to function properly. The program will delete temp.png after the new .png is created. <br> 
Because temp.png is deleted, multiple iterations of the program are permitted. 

### CharacterGeneratorReader
works by reading the names of the files in GeneratedArt/. It then returns each body part with a number, x, next to it where x = the number of times this part is present in generated art. Can be used to determine generated art rarity.

