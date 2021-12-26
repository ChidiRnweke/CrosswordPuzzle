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
            char solutionLetter = solution.charAt(i);
            row[i] = new SolutionSquare(String.valueOf(solutionLetter));
        }
    }

    public void setSolved(String answer) {
        /*
        Checks if all rows are correct, if so it returns true. If one is incorrect it breaks out of the method and
        returns false.
         */
        for (int i = 0; i < row.length; i++){
            if (!row[i].validate(String.valueOf(answer.charAt(i)))){
                this.solved = false;
                return;
            }
        }
        this.solved = true;
    }
}

