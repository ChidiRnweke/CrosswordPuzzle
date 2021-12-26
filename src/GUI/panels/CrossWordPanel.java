package GUI.panels;

import GUI.Keyboard.Keyboard;
import logic.squares.*;

import javax.swing.*;
import java.awt.*;

public class CrossWordPanel extends JPanel{
    /*
    Provides the center panel for the puzzle. It is constructed from a 2d array of square objects.
     */
    public CrossWordPanel(Square[][] squares){
        super();
        GridLayout grid = new GridLayout(squares[0].length,squares[1].length);
        super.setLayout(grid);
        for (int i = 0; i < squares[0].length; i++){
            for (int j = 0; j < squares[1].length; j++){
                Square current = squares[i][j];
                JButton tile = new JButton();
                tile.setText(current.getInput());
                tile.setBackground(chooseColor(current));
                tile.setPreferredSize(new Dimension(10,10));
                if (current instanceof BlackSquare){
                    tile.setEnabled(false);
                }
                else {
                    tile.addActionListener(e -> new Keyboard((FillableSquare) current, tile));
                }
                this.add(tile);
            }
        }
    }

    private Color chooseColor(Square square){
        if (square instanceof BlackSquare){
            return Color.BLACK;
        }
        else if (square instanceof RegularSquare){
            return Color.WHITE;
        }
        else if (square instanceof GreySquare){
            return Color.lightGray;
        }
        else if (square instanceof HelpSquare){
            return Color.CYAN;
        }
        else throw new IllegalArgumentException();
    }


}
