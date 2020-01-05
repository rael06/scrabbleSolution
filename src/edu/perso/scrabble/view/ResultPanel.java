package edu.perso.scrabble.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ResultPanel extends JScrollPane {
    private List<String> results = new ArrayList<>();
    private JPanel resultPanel = new JPanel();

    ResultPanel() {
        super();
        resultPanel.setLayout(new GridLayout(results.size(), 4));
        resultPanel.setOpaque(true);
        resultPanel.setBackground(Color.WHITE);
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth - 20, UIConstants.MainFrameHeight-260));
        getVerticalScrollBar().setUnitIncrement(25);
        setViewportView(resultPanel);
    }

    void show(List<String> results) {
        this.results = results;
        resultPanel.removeAll();
        results.forEach(r -> resultPanel.add(new Title(r)));
        revalidate();
    }
}
