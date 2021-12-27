package GUI.panels;

import GUI.Keyboard.Keyboard;
import logic.factory.SolutionRow;
import logic.squares.FillableSquare;

import javax.swing.*;
import java.awt.*;

public class SolutionPanel {
    /*
    Similar to CrossWordPanel. This represents the buttons on the bottom.
     */

    public JPanel makeSolutionPanel(SolutionRow solutions, String answer) {
        JPanel solutionPanel = new JPanel();

        FillableSquare[] squares = solutions.getRow();  // needs a solution object as it uses its methods later.
        for (FillableSquare current : squares) {
            JButton tile = new JButton();
            tile.setText(current.getInput());
            tile.setBackground(Color.lightGray);
            tile.setPreferredSize(new Dimension(100, 75));
            tile.addActionListener(e -> new Keyboard(current, tile).makeKeyboard()); // when pressed made a new keyboard
            solutionPanel.add(tile);
        } // makes a button for instance in the array.

        JButton validate = new JButton("Press here to answer"); // button to check the final answer
        validate.setBackground(Color.WHITE);
        validate.setPreferredSize(new Dimension(250,50));
        validate.addActionListener(e -> {
            solutions.setSolved();
            if(solutions.isSolved()){
                JOptionPane.showMessageDialog(solutionPanel.getParent(), "Congratulations, you win!");
                validate.setBackground(Color.green); // lambda expression to make an actionListener on the go
            }
        });
        solutionPanel.add(validate);
        return solutionPanel; // returns the JPanel
    }
}

