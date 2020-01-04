package edu.perso.scrabble;

public class Main {
    public static void main(String[] args) {
        //test();
        String dicoSourcePath = args[0];
        Frame f = Frame.getInstance();
        f.init(dicoSourcePath);
    }

    public static void test() {
    }
}
