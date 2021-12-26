package logic.squares;

import java.util.Random;

public class HelpSquare extends FillableSquare{
    /*
    A help square has the potential to provide hints to the end-user.
    getLetterChoices is overriden to provide a hintArray.
     */
    private final String hint;
    private final String[] hintArray = {}; // final means its elements can be mutated.

    public HelpSquare(String hint) {
        /*
        The help square is initialised with a hint.
        */
        this.hint = hint;
    }

    public void giveHint(){
        /*
        Randomly generates a unique set of 4 letters to provide as a hint to the end-user together with the real letter.
         */
        hintArray[0] = hint;
        Random rand = new Random();
        int i = 1;

        while (i < 5){
            int index = rand.nextInt(25);
            String suggestion = letterChoices[index];
            if (checkLetter(suggestion)){
                hintArray[i] = suggestion;
                i++;
            }
        }
    }

    private boolean checkLetter(String suggestion) {
        /*
        Loops over the hint array and checks if the randomly generated letter is already inside.
         */
        for (int j = 0; j < 5; j++) {
            if (suggestion.equals(hintArray[j])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String[] getLetterChoices() {
        /*
        Easiest way is to just override the getter. All FillableSquares return the full alphabet but this one just
        returns 5 letters.
         */
        return hintArray;

    }

}
