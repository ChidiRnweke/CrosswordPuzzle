package logic.squares;

public abstract class FillableSquare extends Square{
    /*
    Fillable squares differ have set methods that can be inherited by the regular, special and help squares.
     */
    protected char[] letterChoices =
            {'A', 'B', 'C','D','E',
                    'F','G','H', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q','R','S','T',
                    'U','V','W','X','Y','Z'};

    protected boolean filled = false;

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setInput(char input){
        this.input = input;
    }

    public char[] getLetterChoices() {
        return letterChoices;
    }
}
