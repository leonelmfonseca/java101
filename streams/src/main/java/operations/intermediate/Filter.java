package operations.intermediate;

import static com.developer.java.output.Printing.*;
import static com.developer.java.output.Streamliner.getListOfStreamElements;
import static com.developer.java.output.Streamliner.stringJoinerByDelimiter;
import static java.lang.System.*;
import static java.lang.System.out;

import com.developer.java.output.Printing;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;
import utils.EnglishWords;

public class Filter {

  private static final int MIN_WORD_LENGTH = 5;
  private static final Random random = new Random();
  private static final List<String> englishWords = EnglishWords.getWords().stream().toList();

  private Filter() {}

  // Main method
  public static void main(String[] args) {
    filterByPrefix();
    lazyFilter();
  }

  private static void filterByPrefix() {

    print("Filter by prefix", 2, 0);

    String prefix = Filter.getRandomPrefix();

    if (prefix == null || prefix.isEmpty()) {
      out.println("No prefixes found.");
      return;
    }

    List<String> prefixWords = filterWordsStartingWith(prefix);
    print("Words starting with:" + prefix, 1, 0);
    String formattedWords = stringJoinerByDelimiter(prefixWords::stream, ", ");
    out.println(formattedWords);
  }

  private static void lazyFilter() {
    List<String> jupiterMoons =
        Arrays.asList(
            "Io", "Europa", "Ganymede", "Callisto", "Amalthea", "Himalia", "Elara", "Pasiphae");

    Stream<String> longStringsStream =
        jupiterMoons.stream()
            .filter(
                s -> {
                  return s.length() > 5;
                });

    print("Demo streams lazy operation", 2, 0);
    print(EQUALS_SEPARATOR);
    
    print("Stream created, but filter was not applied yet, because there is no terminal operation");
    
    Supplier<Stream<String>> streamSupplier = () -> longStringsStream;
    stringJoinerByDelimiter(streamSupplier, ", ");
    getListOfStreamElements(streamSupplier).forEach(Printing::print);
    
    print("forEach is a terminal operation, so stream cannot be used from this point forward");
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
