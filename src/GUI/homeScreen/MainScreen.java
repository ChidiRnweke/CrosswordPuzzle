package GUI.homeScreen;

import GUI.panels.CrossWordPanel;
import logic.factory.SquareArrayFactory;
import logic.input.PuzzleReader;
import logic.squares.Square;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainScreen {


    public MainScreen(String descriptiveText, Square[][] squares){

        JFrame mainScreen = new JFrame();
        ImageIcon icon = new ImageIcon("src/GUI/homeScreen/logo.png");

        mainScreen.setLayout(new BorderLayout());

        mainScreen.setTitle("Swedish-Style crossword puzzle");
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setSize(1500,2000);

        mainScreen.setIconImage(icon.getImage());


        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(500,2000));
        TitledBorder title = BorderFactory.createTitledBorder("Crossword puzzle instructions");
        textPanel.setBorder(title);
        JLabel text = new JLabel(descriptiveText);
        textPanel.add(text);

        CrossWordPanel crosswordpanel = new CrossWordPanel(squares);
        crosswordpanel.setPreferredSize(new Dimension(1000,1000));

        mainScreen.add(textPanel, BorderLayout.WEST);
        mainScreen.add(crosswordpanel, BorderLayout.CENTER);
        mainScreen.setVisible(true);
        mainScreen.pack();
    }

    public static void main(String[] args) {
        PuzzleReader puzzle = new PuzzleReader();
        puzzle.readFile();
        SquareArrayFactory factory = new SquareArrayFactory();
        factory.makeArray(puzzle.getSquares());
        Square[][] squares = factory.getObjectArray();
        String text = puzzle.getDescriptiveText();
        new MainScreen(text,squares);
    }
}
