package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;

class Title extends JPanel {
    Title(String title) {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        add(new JLabel(title));
    }
}
