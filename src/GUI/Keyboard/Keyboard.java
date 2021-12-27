package GUI.Keyboard;

import logic.squares.FillableSquare;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Keyboard{

    /*
    Responsible for showing the keyboard when a button is pressed.
     */

    private final String[] keys =
            {"A", "B", "C","D","E",
                    "F","G","H","I", "J", "K", "L", "M",
                    "N", "O", "P", "Q","R","S","T",
                    "U","V","W","X","Y","Z"};
    private final FillableSquare square;
    private final JButton pressedFrom;

    public Keyboard(FillableSquare square, JButton pressedFrom) {

        this.square = square;
        this.pressedFrom = pressedFrom;
    }
    public void makeKeyboard(){
        /*
        Makes a keyboard when a square was pressed. It looks at its LetterChoices to set the buttons to "enabled".
        In the case of HelpSquare when a hint was given getLetterChoices will return just 5 choices.
         */
        JFrame keyboard = new JFrame("Enter a character");
        List<String>  letterChoices = new ArrayList<>(Arrays.asList(square.getLetterChoices()));
        // getLetterChoices is overriden to return 5 letters for the help class.
        keyboard.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        keyboard.setSize(2000, 250);
        keyboard.setLayout(new FlowLayout());
        keyboard.setVisible(true);
        for (String letter : keys){
            JButton key = new JButton(String.valueOf(letter));
            key.setPreferredSize(new Dimension(75,75));
            key.addActionListener(e -> {
                square.setInput(letter);
                pressedFrom.setText(square.getInput());
                keyboard.dispose();
            }); // Personal preference for lambda expressions as just this button uses this functionality.
            if (!letterChoices.contains(letter)){
                key.setEnabled(false);
            } // Makes sure help buttons only show 5 letters. Each time this is pressed a new set of hints is given.
            keyboard.add(key);
        }
    }


}