package GUI.panels;

import GUI.Keyboard.Keyboard;
import logic.factory.SolutionRow;
import logic.squares.FillableSquare;

import javax.swing.*;
import java.awt.*;

public class SolutionPanel extends JPanel {

    public SolutionPanel(SolutionRow solutions, String answer) {
        super();

        FillableSquare[] squares = solutions.getRow();
        for (FillableSquare current : squares) {
            JButton tile = new JButton();
            tile.setText(current.getInput());
            tile.setBackground(Color.lightGray);
            tile.setPreferredSize(new Dimension(100, 75));
            tile.addActionListener(e -> new Keyboard(current, tile));
            this.add(tile);
        }

        JButton validate = new JButton("Press here to answer");
        validate.setBackground(Color.WHITE);
        validate.setPreferredSize(new Dimension(250,50));
        validate.addActionListener(e -> {
            solutions.setSolved(answer);
            if(solutions.isSolved()){
                JOptionPane.showMessageDialog(this.getParent(), "Congratulations, you win!");
                validate.setBackground(Color.green);
            }
        });
        this.add(validate);
    }
}

