package GUI.Keyboard;

import logic.squares.FillableSquare;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Keyboard extends JFrame{


    private final String[] keys =
            {"A", "B", "C","D","E",
                    "F","G","H","I", "J", "K", "L", "M",
                    "N", "O", "P", "Q","R","S","T",
                    "U","V","W","X","Y","Z"};

    public Keyboard(FillableSquare square, JButton pressedFrom){
        /*
        Makes a keyboard when a square was pressed. It looks at its LetterChoices to set the buttons to enabled.
        In the case of HelpSquare when a hint was given getLetterChoices will return just 5 choices.
         */
        super("Enter a character");
        List<String>  letterChoices = new ArrayList<>(Arrays.asList(square.getLetterChoices()));

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(2000, 250);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        for (String letter : keys){
            JButton key = new JButton(String.valueOf(letter));
            key.setPreferredSize(new Dimension(75,75));
            key.addActionListener(e -> {
                square.setInput(letter);
                pressedFrom.setText(square.getInput());
                this.dispose();
            }); // Personal preference for lambda expressions as just this button uses this functionality.
            if (!letterChoices.contains(letter)){
                key.setEnabled(false);
            } // Makes sure help buttons only show 5 letters.
            this.add(key);
        }
    }


}