package logic.factory;

import logic.squares.Square;

public class SquareArrayFactory {
    /*
    The factory class is able to make one Square object. This class uses the factory class on the string input array to
    create an object array of strings.
     */

    private Square[][] objectArray = {};

    public void makeArray(String[][] squareArray){
        /*
        Makes use of the factory class to make a 2d array of square objects.
         */
        Factory factory = new Factory();
        objectArray = new Square[squareArray[0].length][squareArray[1].length];
        for (int i = 0; i < squareArray[0].length; i++){
            for (int j = 0; j < squareArray[1].length; j++){
                objectArray[i][j] = factory.makeSquare(squareArray[i][j]);
            }
        }
    }

    public Square[][] getObjectArray() {
        return objectArray;
    }
}
