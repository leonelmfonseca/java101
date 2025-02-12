package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import operations.Iteration;

public class DataLoaderUtils {

    private static final String ALL_ENGLISH_WORDS_TXT = "all-english-words.txt";
    private static final Set<String> words = new HashSet<>();

    private static void loadText() {
        // Using try-with-resources to ensure the stream is closed
        try (InputStream inputStream =
                     Iteration.class.getResourceAsStream("/" + ALL_ENGLISH_WORDS_TXT)) {
            assert inputStream != null;
            try (Stream<String> lines = new BufferedReader(new InputStreamReader(inputStream)).lines()) {
                lines.forEach(words::add); // Add each word to the set
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DataLoaderUtils() {}

    public static Set<String> getWords() {
        if(words.isEmpty()) {
            loadText();
        }
        return words;
    }
}
