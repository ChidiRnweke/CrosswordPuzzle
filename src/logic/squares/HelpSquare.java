package logic.squares;

import java.util.Random;

public class HelpSquare extends FillableSquare{
    /*
    A help square has the potential to provide hints to the end-user.
    getLetterChoices is overriden to provide a hintArray if the user has asked for hints.
     */
    private final char hint;
    private boolean hintGiven = false;
    private final char [] hintArray = {'\0','\0','\0','\0','\0'}; // final means its elements can be mutated.

    public HelpSquare(char hint) {
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
            char suggestion = letterChoices[index];
            if (checkLetter(suggestion)){
                hintArray[i] = suggestion;
                i++;
            }
        }
        hintGiven = true;
    }

    private boolean checkLetter(char suggestion) {
        /*
        Loops over the hint array and checks if the randomly generated letter is already inside.
         */
        for (int j = 0; j < 5; j++) {
            if (suggestion == hintArray[j]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public char[] getLetterChoices() {
        /*
        If a hint has been given for a given tile the letter choices returned should be the hintArray.
        If not they should be the default letterChoices that were inherited from the abstract class.
         */
        if (hintGiven) {
            return hintArray;
        } else {
            return super.getLetterChoices();
        }
    }
}
