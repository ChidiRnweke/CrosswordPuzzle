package GUI.homeScreen;

import GUI.panels.CrossWordPanel;
import GUI.panels.SolutionPanel;
import logic.factory.SolutionRow;
import logic.factory.SquareArrayFactory;
import logic.input.PuzzleReader;
import logic.squares.Square;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainScreen {
    /*
    Main screen and main method of the program.
     */

    public MainScreen(String descriptiveText, Square[][] squares, SolutionRow solutionRow, String answer){

        JFrame mainScreen = new JFrame();
        mainScreen.setLayout(new BorderLayout());

        mainScreen.setTitle("Swedish-Style crossword puzzle");
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setSize(1500,2000);


        ImageIcon icon = new ImageIcon("src/GUI/homeScreen/logo.png");
        mainScreen.setIconImage(icon.getImage());  //sets the KUL logo on the screen


        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(200,2000));
        textPanel.setLayout(new BorderLayout());
        TitledBorder title = BorderFactory.createTitledBorder("Crossword puzzle instructions");
        textPanel.setBorder(title);
        JLabel text = new JLabel(descriptiveText);
        textPanel.add(text); // This panel does not modify or change any behaviour JPanel, so it is just placed on it.

        SolutionPanel solutionPanel = new SolutionPanel(solutionRow, answer); //SolutionPanel extends JPanel
        solutionPanel.setPreferredSize(new Dimension(1500, 100));



        CrossWordPanel crosswordpanel = new CrossWordPanel(squares); //CrossWordPanel extends JPanel
        crosswordpanel.setPreferredSize(new Dimension(1000,1000));

        mainScreen.add(textPanel, BorderLayout.WEST);
        mainScreen.add(crosswordpanel, BorderLayout.CENTER);
        mainScreen.add(solutionPanel, BorderLayout.SOUTH);
        mainScreen.setVisible(true);
        mainScreen.pack();
    }


    public static void main(String[] args) {
        PuzzleReader puzzle = new PuzzleReader(); // reads the input file
        SquareArrayFactory factory = new SquareArrayFactory(); // responsible for making the square objects
        SolutionRow solutionRow = new SolutionRow(); // responsible for making the bottom row

        puzzle.readFile();

        solutionRow.makeRow(puzzle.getSolution()); // solution squares are made
        factory.makeArray(puzzle.getSquares()); // crossword squares are made

        new MainScreen(puzzle.getDescriptiveText(),factory.getObjectArray(), solutionRow, puzzle.getSolution());
    }
}
