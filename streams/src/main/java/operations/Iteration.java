package operations;

import utils.EnglishWords;

import static exec.MethodExecutioner.measureExecutionTime;

public class Iteration {
  private static final Integer BIG_WORDS_THRESHOLD = 30;

  public static void main(String[] args) {

    measureExecutionTime(Iteration::classicalLoop);
    System.out.println();
    measureExecutionTime(Iteration::streamLoop);
    System.out.println();
    measureExecutionTime(Iteration::parallelStreamLoop);
  }





  public static void classicalLoop() {
    long bigWords = 0;
    for (String word : EnglishWords.getWords()) {
      if (word.length() > BIG_WORDS_THRESHOLD) {
        bigWords++;
      }
    }
    System.out.println("Big words  using classical loop: " + bigWords);

  }

  // Streams follow the “what, not how” principle
  public static void streamLoop() {
    long bigWords = EnglishWords.getWords().stream().filter(w->w.length() > BIG_WORDS_THRESHOLD).count();
     System.out.println("Big words using stream loop: " + bigWords);

  }

  public static void parallelStreamLoop() {
    long bigWords = EnglishWords.getWords().parallelStream().filter(w->w.length() > BIG_WORDS_THRESHOLD).count();
    System.out.println("Big words using parallel stream loop: " + bigWords);
  }
}
