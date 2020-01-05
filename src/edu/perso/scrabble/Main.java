package edu.perso.scrabble;

import edu.perso.scrabble.view.Frame;

public class Main {
    public static void main(String[] args) {
        String dictionarySourcePath = args[0];
        Frame f = Frame.getInstance();
        f.init(dictionarySourcePath);
    }
}
