package operations;

import utils.DataLoaderUtils;

public class Iteration {
  private static final Integer BIG_WORDS_THRESHOLD = 30;

  public static void main(String[] args) {

    measureExecutionTime(Iteration::classicalLoop);
    System.out.println();
    measureExecutionTime(Iteration::streamLoop);
    System.out.println();
    measureExecutionTime(Iteration::parallelStreamLoop);
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
    for (String word : DataLoaderUtils.getWords()) {
      if (word.length() > BIG_WORDS_THRESHOLD) {
        bigWords++;
      }
    }
    System.out.println("Big words  using classical loop: " + bigWords);

  }

  // Streams follow the “what, not how” principle
  public static void streamLoop() {
    long bigWords = DataLoaderUtils.getWords().stream().filter(w->w.length() > BIG_WORDS_THRESHOLD).count();
     System.out.println("Big words using stream loop: " + bigWords);

  }

  public static void parallelStreamLoop() {
    long bigWords = DataLoaderUtils.getWords().parallelStream().filter(w->w.length() > BIG_WORDS_THRESHOLD).count();
    System.out.println("Big words using parallel stream loop: " + bigWords);
  }
}
