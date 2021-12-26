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


    public MainScreen(String descriptiveText, Square[][] squares, SolutionRow solutionRow, String answer){

        JFrame mainScreen = new JFrame();
        ImageIcon icon = new ImageIcon("src/GUI/homeScreen/logo.png");

        mainScreen.setLayout(new BorderLayout());

        mainScreen.setTitle("Swedish-Style crossword puzzle");
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setSize(1500,2000);

        mainScreen.setIconImage(icon.getImage());


        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(200,2000));
        textPanel.setLayout(new BorderLayout());
        TitledBorder title = BorderFactory.createTitledBorder("Crossword puzzle instructions");
        textPanel.setBorder(title);
        JLabel text = new JLabel(descriptiveText);
        textPanel.add(text);

        SolutionPanel solutionPanel = new SolutionPanel(solutionRow, answer);
        solutionPanel.setPreferredSize(new Dimension(1500, 100));



        CrossWordPanel crosswordpanel = new CrossWordPanel(squares);
        crosswordpanel.setPreferredSize(new Dimension(1000,1000));

        mainScreen.add(textPanel, BorderLayout.WEST);
        mainScreen.add(crosswordpanel, BorderLayout.CENTER);
        mainScreen.add(solutionPanel, BorderLayout.SOUTH);
        mainScreen.setVisible(true);
        mainScreen.pack();
    }


    public static void main(String[] args) {
        PuzzleReader puzzle = new PuzzleReader();
        SquareArrayFactory factory = new SquareArrayFactory();
        puzzle.readFile();
        String answer= puzzle.getSolution();
        SolutionRow solutionRow = new SolutionRow();
        solutionRow.makeRow(puzzle.getSolution());
        factory.makeArray(puzzle.getSquares());
        Square[][] squares = factory.getObjectArray();
        String text = puzzle.getDescriptiveText();
        new MainScreen(text,squares, solutionRow, answer);
    }
}
