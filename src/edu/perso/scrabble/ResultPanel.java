package edu.perso.scrabble;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultPanel extends JScrollPane {
    private List<String> results = new ArrayList<>();
    private JPanel resultPanel = new JPanel();

    public ResultPanel() {
        super();
        resultPanel.setLayout(new GridLayout(results.size(), 4));
        resultPanel.setOpaque(true);
        resultPanel.setBackground(Color.WHITE);
        setPreferredSize(new Dimension(UIConstants.MainFrameWidth - 20, UIConstants.MainFrameHeight-260));
        getVerticalScrollBar().setUnitIncrement(25);
        setViewportView(resultPanel);
    }

    public void show(List<String> results) {
        this.results = results;
        resultPanel.removeAll();
        results.forEach(r -> resultPanel.add(new Title(r)));
        revalidate();
    }
}
