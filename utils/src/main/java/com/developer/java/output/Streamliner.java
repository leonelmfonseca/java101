package com.developer.java.output;

import java.util.List;
import java.util.stream.Collectors;

public class Streamliner {
    
    private Streamliner() {}
    
    public static String stringJoinnerByDelimiter(List<String> words, String delimiter) {
        return words.stream().map(String::toLowerCase).collect(Collectors.joining(delimiter));
    }
}
