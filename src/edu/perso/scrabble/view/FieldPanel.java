package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    private Field field;

    FieldPanel(String title) {
        Title t = new Title(title);
        field = new Field();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth,70));

        add(BorderLayout.NORTH, t);
        add(BorderLayout.CENTER, field);
    }

    Field getField() {
        return field;
    }
}
