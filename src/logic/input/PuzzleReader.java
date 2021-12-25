package logic.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PuzzleReader {
    /*
    This class is responsible for reading the input file and storing its information in a handful of variables.
    The key idea of this class is that the scanner is used between functions.
     */
    private int horizontalDimension;
    private int verticalDimension;
    private String[][] tiles = {};
    private final String inputPath;
    private String descriptiveText = null;

    public PuzzleReader() {
         /*
        The default constructor sets the input path to puzzle1
         */
        this.inputPath = Path.of("src", "logic", "input", "puzzle-1.txt").toAbsolutePath().toString();
    }

    public PuzzleReader(String puzzleFile){
        /*
        This constructor allows you to read in a different puzzle than the one provided in the assignment.
         */
        this.inputPath = Path.of("src", "logic", "input", puzzleFile).toAbsolutePath().toString();
    }

    public void readFile(){
        /*
         A single try with resources block in readFile() is responsible for closing the scanner for each function.
         */
        try(Scanner scan = new Scanner(new File(inputPath))){
            readDimensions(scan);
            readTiles(scan);
            readDescriptiveText(scan);
        }
        catch (FileNotFoundException e) {
            System.out.println("No file was found at the current path: " + inputPath + ". Are you sure it is present?");
        }
    }

    private void readDimensions(Scanner scan) {
        /*
        Reads in the dimensions (horizontal and vertical) of the first file.
        The scanner is not closed in the 'finally' block as it is passed to the next function.
         */
        try {
            verticalDimension = scan.nextInt();
            horizontalDimension = scan.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("The dimensions provided should be integer, are you sure the right file was provided?");
        }
    }

    private void readTiles(Scanner scan){
        /*
         Takes the previously made scanner and parses the table based on the dimensions.
         */
        tiles = new String[verticalDimension][horizontalDimension];
        try{
            for (int i = 0; i < verticalDimension; i++){
                for (int j = 0; j < horizontalDimension; j++){
                    tiles[i][j] = scan.next();
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("The data provided is in an incorrect format.");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Failed to read in the table. Make sure the dimensions are correct.");
        }
    }

    private void readDescriptiveText(Scanner scan){
        /*
        Reads the descriptive text from the file and stores it in a single String.
         */
        try{
            descriptiveText = scan.useDelimiter("\\Z").next();
        }
        catch (InputMismatchException e) {
            System.out.println("The data provided is in an incorrect format.");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Failed to read in the descriptive text. Make sure the dimensions are correct.");
        }
    }

    public int getHorizontalDimension() {
        return horizontalDimension;
    }

    public int getVerticalDimension() {
        return verticalDimension;
    }

    public String[][] getTiles() {
        return tiles;
    }

    public String getDescriptiveText() {
        return descriptiveText;
    }
}





