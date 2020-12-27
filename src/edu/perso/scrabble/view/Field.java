package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Field extends JPanel {
    private String text = "";
    private JTextField textField;

    Field() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(true);
        textField = new JTextField(20);
        add(textField);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                showText(textField);
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == 0)
                    text = textField.getText();
            }
        });

    }

    private void showText(JTextField tf) {
        text = tf.getText();
    }

    String getText() {
        return text;
    }

    JTextField getTextField() {
        return textField;
    }
}
