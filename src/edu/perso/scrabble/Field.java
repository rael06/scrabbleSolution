package edu.perso.scrabble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Field extends JPanel {
    private String text = "";
    public Field() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(true);
        JTextField tf = new JTextField(20);
        add(tf);

        tf.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                showText(tf);
            }
        });

    }

    private void showText(JTextField tf) {
        text = tf.getText();
    }

    public String getText() {
        return text;
    }
}
