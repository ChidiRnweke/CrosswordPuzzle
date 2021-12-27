package logic.factory;
import logic.squares.SolutionSquare;

public class SolutionRow {
    /*
    Makes a row of solution squares. Also provides a method to validate their input.
     */
    private SolutionSquare[] row = {};
    private boolean solved = false;

    public void makeRow(String solution){
        /*
        Takes in the solution string and makes an array of SolutionSquares.
         */
        row = new SolutionSquare[solution.length()];
        for (int i = 0; i < solution.length(); i++){
            String solutionLetter = String.valueOf(solution.charAt(i));
            row[i] = new SolutionSquare(solutionLetter);
        }
    }

    public void setSolved() {
        /*
        Checks if all rows are correct, if so it returns true. If one is incorrect it breaks out of the loop and
        returns false.
         */
        for (SolutionSquare solutionSquare : row) {
            if (!solutionSquare.validate()) { // the validate method of a SolutionSquare just checks if the strings are equal
                this.solved = false;
                return;
            }
        }
        this.solved = true;
    }

    public SolutionSquare[] getRow() {
        return row;
    }

    public boolean isSolved() {
        return solved;
    }
}

