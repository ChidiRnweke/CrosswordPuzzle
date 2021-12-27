package logic.squares;

public abstract class FillableSquare extends Square{
    /*
    Fillable squares differ have set methods that can be inherited by the regular, special and help squares.
     */
    protected String[] letterChoices =
            {"A", "B", "C","D","E",
                    "F","G","H", "I", "J", "K", "L", "M",
                    "N", "O", "P", "Q","R","S","T",
                    "U","V","W","X","Y","Z"};

    public void setInput(String input){
        this.input = input;
    }

    public String[] getLetterChoices() {
        return letterChoices;
    }
}
