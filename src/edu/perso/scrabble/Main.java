package edu.perso.scrabble;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String sourcePath;

    public static void main(String[] args) {
        init(args);

        // dictionary creation
        Dictionary dictionary = Dictionary.getInstance();
        dictionary.init(sourcePath);

        // test
        new Frame();
        // test(dictionary);
    }

    private static void init(String[] args) {
        sourcePath = args[0];
    }

    private static Pattern createPattern(String letters) {
        StringBuilder sb = new StringBuilder();
        String[] aLetters = letters.split("");
        sb.append("(?i)^[");
        for (String l : aLetters) {
            if (l.equals("?")) continue;
            sb.append(l);
        }
        if (letters.contains("?")) {
            sb.append("A-Z");
        }
        sb.append("]{2,");
        sb.append(letters.length());
        sb.append("}$");
        System.out.println(sb.toString());
        return Pattern.compile(sb.toString());
    }

    private static void test(Dictionary dic) {
        List<String> results = new ArrayList<>();
        List<String> words = dic != null ? dic.getWords() : null;

        String letters = "cray?";
        List<String> lChars = Arrays.asList(letters.toUpperCase().split(""));
        int nbJoker = (int) lChars.stream().filter(c -> c.equals("?")).count();

        List<String> wChars;
        assert words != null;
        for (String word : words) {
            if (word.length() > letters.length()) continue;
            wChars = Arrays.asList(word.split(""));

            boolean valid = wChars.stream().filter(wc->!lChars.contains(wc)).count() <= nbJoker;
            for (String lChar : lChars) {
                int countInLetters = (int) lChars.stream().filter(lc -> lc.equals(lChar)).count();
                int countInWord = (int) wChars.stream().filter(wc -> wc.equals(lChar)).count();
                valid &= countInWord <= countInLetters;
                if (!valid) break;
            }

            if (valid) {
                results.add(word);
            }
        }

        results.sort(Comparator.comparingInt(String::length));
        for (String r : results) {
            System.out.println(r);
        }
    }
}
