package operations;

import com.developer.java.output.Printing;
import com.developer.java.output.Streamliner;
import java.util.List;
import java.util.Random;
import utils.EnglishWords;

public class Filter {

  private static final int MIN_WORD_LENGTH = 5;
  private static final Random random = new Random();
  private static final List<String> englishWords = EnglishWords.getWords().stream().toList();

  private Filter() {}

  // Main method
  public static void main(String[] args) {
    filterByPrefix();
  }

  private static void filterByPrefix() {

    Printing.print("Filter by prefix", 2, 0);
    Printing.print(Printing.EQUALS_SEPARATOR);

    String prefix = Filter.getRandomPrefix();

    if (prefix == null || prefix.isEmpty()) {
      System.out.println("No prefixes found.");
      return;
    }

    List<String> prefixWords = filterWordsStartingWith(prefix);
    Printing.print("Words starting with:" + prefix, 1, 0);
    String formattedWords = Streamliner.stringJoinerByDelimiter(prefixWords :: stream, ", ");
    System.out.println(formattedWords);
  }

  private static String getRandomPrefix() {

    // Filter by prefix length
    List<String> validWords =
        Filter.englishWords.stream().filter(Filter::isWordLengthEnough).toList();

    if (validWords.isEmpty()) {
      return null;
    }

    int randomIndex = random.nextInt(validWords.size());
    return validWords.get(randomIndex).substring(0, MIN_WORD_LENGTH).toLowerCase();
  }

  private static List<String> filterWordsStartingWith(String word) {
    return englishWords.stream()
        .filter(w -> w.toLowerCase().startsWith(word.toLowerCase()))
        .toList();
  }

  private static boolean isWordLengthEnough(String word) {
    return word.length() >= MIN_WORD_LENGTH;
  }
}
