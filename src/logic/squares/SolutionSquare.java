package logic.squares;

/*
Forms the basis for the three FillableSquares: GreySquare, HelpSquare and RegularSquare.
 */
public class SolutionSquare extends FillableSquare{
    private final char solution;

    public SolutionSquare(char solution){
        this.solution = solution;
    }

    public boolean validate(char answer){
        return solution == answer;
    }
}
