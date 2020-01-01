package edu.perso.scrabble;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static Dictionary instance;
    private List<String> words = new ArrayList<>();

    private Dictionary() {
    }

    public static Dictionary getInstance() {
        return instance = instance == null ? new Dictionary() : instance;
    }

    public void init(String sourcePath) {
        try {
            words.addAll(Files.readAllLines(Paths.get(sourcePath)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWords() {
        return words;
    }
}
