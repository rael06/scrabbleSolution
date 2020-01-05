package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;

class ResultWord extends JPanel {
    ResultWord(String word) {
        super();
        JLabel wordLabel = new JLabel("(" + word.length() + ") " + word);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        wordLabel.setOpaque(true);
        wordLabel.setBackground(Color.WHITE);
        add(wordLabel);
    }
}
