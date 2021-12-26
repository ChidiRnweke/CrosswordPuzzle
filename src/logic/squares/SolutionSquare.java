package logic.squares;

/*
Forms the basis for the three FillableSquares: GreySquare, HelpSquare and RegularSquare.
 */
public class SolutionSquare extends FillableSquare{
    private final String solution;

    public SolutionSquare(String solution){
        this.solution = solution;
    }

    public boolean validate(String answer){
        return solution.equals(answer);
    }
}
