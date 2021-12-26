package logic.squares;
/*
Abstract base class for all the squares that follow. The goal is to have as much functionality here as possible.
 */
public abstract class Square {
    protected char input = '\0';
    protected boolean filled;

    public char getInput() {
        return input;
    }

    public boolean isFilled() {
        return filled;
    }
}
