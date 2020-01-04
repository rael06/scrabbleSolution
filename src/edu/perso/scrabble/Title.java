package edu.perso.scrabble;

import javax.swing.*;
import java.awt.*;

public class Title extends JPanel {
    public Title(String title) {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        add(new JLabel(title));
    }
}
