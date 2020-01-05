package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ResultPanel extends JScrollPane {
    private static final int COLS = 4;
    private List<String> results = new ArrayList<>();
    private JPanel resultPanel = new JPanel();

    ResultPanel() {
        super();
        resultPanel.setLayout(new GridLayout(0, COLS));
        resultPanel.setBackground(Color.WHITE);
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth - 20, UIConstants.MainFrameHeight-260));
        getVerticalScrollBar().setUnitIncrement(25);
        setViewportView(resultPanel);
    }

    void show(List<String> results) {
        this.results = results;
        resultPanel.removeAll();
        results.forEach(r -> resultPanel.add(new ResultWord(r)));
        repaint();
        revalidate();
    }
}
