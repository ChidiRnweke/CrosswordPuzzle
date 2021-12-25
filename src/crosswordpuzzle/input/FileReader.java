package crosswordpuzzle.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReader {
    /*
    This class is responsible for reading the input file and storing its information in a handful of variables.
     */
    private int horizontal;
    private int vertical;
    private char[][] tiles;
    private String inputPath;

    public FileReader() {
        /*
        The default constructor sets the input path to puzzle1
         */
        this.inputPath = Path.of("src", "crosswordpuzzle", "input", "puzzle-1.txt").toAbsolutePath().toString();
    }

    public FileReader(String puzzleFile){
        /*
        This constructor allows you to read in a different puzzle than the one provided in the assignment.
         */
        this.inputPath = Path.of("src", "crosswordpuzzle", "input", puzzleFile).toAbsolutePath().toString();
    }

    private void readDimensions() {
        /*
        Reads in the dimensions (horizontal and vertical of the first file.
         */
        try (Scanner scan = new Scanner(new File(inputPath))) {
            int vertical = scan.nextInt();
            int horizontal = scan.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("No file was found at the current path: " + inputPath +". Are you sure it is present?");
        }
        catch (InputMismatchException e) {
            System.out.println("The dimensions provided should be integer, are you sure the right file was provided?");
        }
    }
    public void readTable(Scanner scan){
        /*
         Takes the previously made scanner and parses the table based on the dimensions.
         */
        for (int i = 0; i < horizontal; i++){
            for (int j = 0; j < vertical; j++){

            }
        }

    }





}