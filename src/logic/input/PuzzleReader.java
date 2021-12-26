package logic.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class PuzzleReader {
    /*
    This class is responsible for reading the input file and storing its information in a handful of variables.
    The key idea of this class is that the scanner is used between functions.
     */
    private int horizontalDimension;
    private int verticalDimension;
    private String[][] squares = {};
    private String solution;
    private String descriptiveText = null;


    public void readFile(){
        /*
         A single try with resources block in readFile() is responsible for closing the scanner for each function.
         */

        String inputPath = Path.of("src", "logic", "input", "puzzle-1.txt").toAbsolutePath().toString();
        this.solution = readSolution();

        try(Scanner scan = new Scanner(new File(inputPath))){
            readDimensions(scan);
            readTiles(scan);
            readDescriptiveText(scan);
        }
        catch (FileNotFoundException e) {
            System.out.println("No file was found at the current path: " + inputPath + ". Are you sure it is present?");
        }
    }

    private String readSolution(){
        /*
        Reads the solution from the config file.
         */
        String configPath = Path.of("src", "logic", "input", "config.properties").toAbsolutePath().toString();
        Properties config = new Properties();

        try(FileInputStream configFile = new FileInputStream(configPath)){
            config.load(configFile);
            return config.getProperty("solution");
        }
        catch (FileNotFoundException e){
            System.out.println("Solution file not found");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
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
        squares = new String[verticalDimension][horizontalDimension];
        try{
            for (int i = 0; i < verticalDimension; i++){
                for (int j = 0; j < horizontalDimension; j++){
                    squares[i][j] = scan.next();
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

    /*
    Only accessors that are used are made.
     */

    public String[][] getSquares() {
        return squares;
    }

    public String getDescriptiveText() {
        return descriptiveText;
    }

    public String getSolution() {
        return solution;
    }
}





