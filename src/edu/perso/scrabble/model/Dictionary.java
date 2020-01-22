package edu.perso.scrabble.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {
    private static Dictionary instance;
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

    public List<String> find(String letters, String lettersToAdd, String pattern) {
        List<String> results = new ArrayList<>();
        letters += lettersToAdd;
        Pattern p = createPattern(pattern);

        List<String> toFindChars = Arrays.asList(letters.toUpperCase().split(""));
        int nbJoker = (int) toFindChars.stream().filter(c -> c.equals("*")).count();

        List<String> currentWordChars;
        assert words != null;
        for (String word : words) {
            if (word.length() > letters.length()) continue;
            currentWordChars = Arrays.asList(word.split(""));

            boolean valid = p.matcher(word).find();
            valid &= word.matches("(?i).*"+ lettersToAdd + ".*");
            valid &= currentWordChars.stream().filter(wc->!toFindChars.contains(wc)).count() <= nbJoker;

            for (String currentToFindChar : toFindChars) {
                int countOfCurrentToFindCharInToFind = (int) toFindChars.stream().filter(lc -> lc.equals(currentToFindChar)).count();
                int countOfCurrentToFindCharInCurrentWord = (int) currentWordChars.stream().filter(wc -> wc.equals(currentToFindChar)).count();
                valid &= countOfCurrentToFindCharInCurrentWord <= countOfCurrentToFindCharInToFind;
                if (!valid) break;
            }
            if (valid) {
                results.add(word);
            }
        }

        results.sort(Comparator.comparingInt(String::length));
        return results;
    }

    public void show(List<String> results) {
        if (results.isEmpty()) System.out.println("Aucun résultat");
        results.forEach(System.out::println);
    }

    private Pattern createPattern(String sPattern) {
        String s = sPattern;
        Pattern p = Pattern.compile("(?i)(\\**\\*)(?:[a-z]+)");
        Matcher m = p.matcher(s);
        while (m.find()) {
            s = s.replace(m.group(), m.group().replaceAll("\\*", "\\[a-z]"));
        }
        s = s.replaceAll("\\*", "\\[a-z]?");
        return Pattern.compile("(?i)^" + s + ".*$");
    }
}
