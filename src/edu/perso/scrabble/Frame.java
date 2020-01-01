package edu.perso.scrabble;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {
    JButton addPattern;
    JButton addText;
    JButton results;
    List<JButton> buttons = new ArrayList<>();
    public Frame() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,200));
        pack();
        setLocationRelativeTo(null);

        initButtons();
    }

    private void initButtons() {
        add(addPattern);
        add(addText);
        add(results);
    }
}
