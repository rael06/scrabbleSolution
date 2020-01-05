package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class ResultPanel extends JScrollPane {
    private static final int COLS = 4;
    private JPanel resultPanel = new JPanel();

    ResultPanel() {
        super();
        resultPanel.setLayout(new GridLayout(0, COLS));
        resultPanel.setBackground(Color.WHITE);
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth - 20, UIConstants.MainFrameHeight - 335));
        getVerticalScrollBar().setUnitIncrement(25);
        setViewportView(resultPanel);
    }

    void show(List<String> results) {
        resultPanel.removeAll();
        if (results.isEmpty()) {
            ((GridLayout) resultPanel.getLayout()).setColumns(1);
            resultPanel.add(new Title("Aucun résultat"));
        } else {
            ((GridLayout) resultPanel.getLayout()).setColumns(COLS);
            results.forEach(r -> resultPanel.add(new ResultWord(r)));
        }

        repaint();
        revalidate();
    }
}
