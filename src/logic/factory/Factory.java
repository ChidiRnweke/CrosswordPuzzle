package logic.factory;

import logic.squares.*;
public class Factory {
    /*
    Returns the correct square on the basis of what input is provided.
     */
    public Square makeSquare(String type){
        /*
        Determines what square needs to be made. If the first char is neither O,X,S nor H an exception is thrown.
         */

        switch (type.charAt(0)) {
            case 'O':
                return new RegularSquare();
            case 'X':
                return new BlackSquare();
            case 'S':
                return new GreySquare();
            case 'H':
                String hint = parseHint(type);
                return new HelpSquare(hint);
            default:
                throw new IllegalArgumentException();
        }
    }

    private String parseHint(String hint){
        /*
        For a help square the hint is found at the second index.
         */
        return String.valueOf(hint.charAt(2));
    }
}
