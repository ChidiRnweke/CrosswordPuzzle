package logic.factory;

import logic.input.PuzzleReader;
import logic.squares.Square;

public class Puzzle {
    private Square[][] squares = {};
    private SolutionRow solutionRow;
    private String solution;
    private String descriptiveText;

    public void startPuzzle(){
        PuzzleReader puzzle = new PuzzleReader(); // reads the input file
        puzzle.readFile();

        SquareArrayFactory saFactory = new SquareArrayFactory(); // responsible for making the square objects
        solutionRow = new SolutionRow(); // responsible for making the bottom row
        solutionRow.makeRow(puzzle.getSolution()); // solution squares are made
        saFactory.makeArray(puzzle.getSquares()); // crossword squares are made

        squares = saFactory.getObjectArray();
        solution = puzzle.getSolution();
        descriptiveText = puzzle.getDescriptiveText();
    }

    public Square[][] getSquares() {
        return squares;
    }

    public SolutionRow getSolutionRow() {
        return solutionRow;
    }

    public String getSolution() {
        return solution;
    }

    public String getDescriptiveText() {
        return descriptiveText;
    }
}
