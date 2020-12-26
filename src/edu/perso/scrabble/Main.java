package edu.perso.scrabble;

import edu.perso.scrabble.view.Frame;

public class Main {
    public static void main(String[] args) {
        String dictionarySourcePath = args.length > 0 ? args[0] : "src/edu/perso/scrabble/dico.txt";
        Frame f = Frame.getInstance();
        f.init(dictionarySourcePath);
    }
}
