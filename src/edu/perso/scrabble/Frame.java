package edu.perso.scrabble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Frame extends JFrame {
    private Dictionary dictionary;
    private ResultPanel resultPanel;
    private FieldPanel lettersPanel;
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
        lettersPanel = new FieldPanel("Letters");
        add(lettersPanel);

        patternPanel = new FieldPanel("Contraintes");
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
        String pattern = patternPanel.getField().getText();
        List<String> results = dictionary.find(letters, pattern);
        resultPanel.show(results);
        dictionary.show(results);
        revalidate();
    }

    public void init(String dicPath) {
        dictionary = Dictionary.getInstance();
        dictionary.init(dicPath);
    }
}
