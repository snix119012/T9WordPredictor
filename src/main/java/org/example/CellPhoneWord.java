package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CellPhoneWord {
    private final Map<String, ArrayList<String>> mainMap = new HashMap<>();

    public CellPhoneWord() {
        String[] dictionary = {"hello", "no", "good", "nice", "pc", "cpp", "code", "adg", "beh",
                "data", "web",  "html", "css", "art", "api", "git", "sql",
                "dev", "iot", "php", "xml", "json", "ajax", "css", "sass", "less", "npm",
                "vue", "react", "any", "bash", "perl", "ruby", "c", "csharp", "go", "dart",
                "kotlin", "swift", "rust", "java", "cuda", "ajax", "rest", "soap", "wasm",
                "pwa", "dom", "node", "edge", "api", "git", "cli", "npm", "cdn", "dns", "sdk"};

        for (String word : dictionary) {
            StringBuilder digitStringBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                Map<Character, Character> charToDigit = Stream.of(
                        new Object[][]{
                                {'a', '2'}, {'b', '2'}, {'c', '2'},
                                {'d', '3'}, {'e', '3'}, {'f', '3'},
                                {'g', '4'}, {'h', '4'}, {'i', '4'},
                                {'j', '5'}, {'k', '5'}, {'l', '5'},
                                {'m', '6'}, {'n', '6'}, {'o', '6'},
                                {'p', '7'}, {'q', '7'}, {'r', '7'},
                                {'s', '7'}, {'t', '8'}, {'u', '8'},
                                {'v', '8'}, {'w', '9'}, {'x', '9'},
                                {'y', '9'}, {'z', '9'}
                        }
                ).collect(Collectors.toMap(data -> (Character) data[0], data -> (Character) data[1]));
                digitStringBuilder.append(charToDigit.get(c));
            }
            String digitString = digitStringBuilder.toString();

            mainMap.computeIfAbsent(digitString, k -> new ArrayList<>()).add(word);
        }
    }
    public ArrayList<String> getMatchingWords(String key) {
        return mainMap.get(key);
    }
}