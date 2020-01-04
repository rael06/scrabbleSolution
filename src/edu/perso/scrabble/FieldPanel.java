package edu.perso.scrabble;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    private Field field;
    private Title title;

    public FieldPanel(String title) {
        this.title = new Title(title);
        field = new Field();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth,70));

        add(BorderLayout.NORTH, this.title);
        add(BorderLayout.CENTER, field);
    }

    public Field getField() {
        return field;
    }

    public Title getTitle() {
        return title;
    }
}
