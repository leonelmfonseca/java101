package operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Iteration {
  private static final String ALL_ENGLISH_WORDS_TXT = "all-english-words.txt";
  private static final Integer BIG_WORDS_THRESHOLD = 30;
  private static Set<String> words = new HashSet<>();

  public static void main(String[] args) {
    loadText();

    measureExecutionTime(Iteration::classicalLoop);
    measureExecutionTime(Iteration::streamLoop);
    measureExecutionTime(Iteration::parallelStreamLoop);
  }

  private static void loadText() {
    // Using try-with-resources to ensure the stream is closed
    try (InputStream inputStream =
            Iteration.class.getResourceAsStream("/" + ALL_ENGLISH_WORDS_TXT);
        Stream<String> lines = new BufferedReader(new InputStreamReader(inputStream)).lines()) {
      lines.forEach(words::add); // Add each word to the set
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // TODO: Migrate to Utils Module
  public static void measureExecutionTime(Runnable task) {
    long startTime = System.currentTimeMillis(); // Start time
    // Execute the task
    task.run();
    long endTime = System.currentTimeMillis(); // End time
    long duration = endTime - startTime; // Duration in milliseconds
    System.out.println("Execution time: " + duration + " milliseconds");
  }

  public static void classicalLoop() {
    long bigWords = 0;
    for (String word : words) {
      if (word.length() > BIG_WORDS_THRESHOLD) {
        bigWords++;
      }
    }
    System.out.println("Big words: " + bigWords);
  }

  // Streams follow the “what, not how” principle
  public static void streamLoop() {
    long bigWords = words.stream().filter(w->w.length() > BIG_WORDS_THRESHOLD).count();
     System.out.println("Big words: " + bigWords);
  }

  // TODO: This takes less time than classical loop, but more than simple stream loop, why ?
  public static void parallelStreamLoop() {
    long bigWords = words.parallelStream().filter(w->w.length() > BIG_WORDS_THRESHOLD).count();
    System.out.println("Big words: " + bigWords);
  }
}
