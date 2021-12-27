package logic.squares;

/*
Forms the basis for the three FillableSquares: SpecialSquare, HelpSquare and RegularSquare.
 */
public class SolutionSquare extends FillableSquare{
    private final String solution;

    public SolutionSquare(String solution){
        this.solution = solution;
    }

    public boolean validate(){
        return solution.equalsIgnoreCase(input);
    }
}
