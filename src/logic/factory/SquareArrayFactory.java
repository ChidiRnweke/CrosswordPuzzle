package logic.factory;

import logic.squares.Square;

public class SquareArrayFactory {
    private final String[][] squareArray;
    private final Square[][] objectArray = {};

    public SquareArrayFactory(String[][] squareArray){
        this.squareArray = squareArray;
    }

    public void makeArray(){
        Factory factory = new Factory();
        for (int i = 0; i < squareArray[0].length; i++){
            for (int j = 0; i < squareArray[1].length; j++){
                objectArray[i][j] = factory.makeSquare(squareArray[i][j]);
            }
        }
    }
}
