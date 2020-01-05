package edu.perso.scrabble.view;

import edu.perso.scrabble.model.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Frame extends JFrame {
    private Dictionary dictionary;
    private ResultPanel resultPanel;
    private FieldPanel lettersPanel;
    private FieldPanel lettersToAddPanel;
    private FieldPanel patternPanel;

    private static Frame instance;

    public static Frame getInstance() {
        return instance = instance == null ? new Frame() : instance;
    }

    private Frame() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth, UIConstants.MainFrameHeight));

        initTextFields();
        initButtons();
        resultPanel = new ResultPanel();
        add(resultPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void initTextFields() {
        lettersPanel = new FieldPanel("Lettres du banc (indiquez les jokers par des \"*\")");
        add(lettersPanel);

        lettersToAddPanel = new FieldPanel("Lettres additionnelles (séparez les groupes de lettres par un \".\")");
        add(lettersToAddPanel);

        patternPanel = new FieldPanel("Contraintes de position/contenu de lettres (comblez avec des \"*\" les lettres prévues entre les lettres contraintes)");
        add(patternPanel);
    }

    private void initButtons() {
        JPanel resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension(UIConstants.MainFrameWidth, 60));
        JButton resultButton = new JButton("Chercher");
        resultButton.setPreferredSize(new Dimension(100, 40));
        resultButton.addActionListener(this::showResult);
        resultPanel.add(resultButton);
        add(resultPanel);
    }

    private void showResult(ActionEvent e) {
        String letters = lettersPanel.getField().getText();
        String lettersToAdd = lettersToAddPanel.getField().getText();
        String pattern = patternPanel.getField().getText();
        List<String> results = dictionary.find(letters, lettersToAdd, pattern);
        resultPanel.show(results);
        //dictionary.show(results);
        revalidate();
    }

    public void init(String dicPath) {
        dictionary = Dictionary.getInstance();
        dictionary.init(dicPath);
    }
}
