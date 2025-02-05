package features;

import com.developer.java.output.Printing;
import com.developer.java.output.Streamliner;
import java.util.function.Supplier;
import java.util.stream.Stream;
import com.developer.java.output.Printing;

import static com.developer.java.output.Printing.printBlock;

public class StreamCreation {

  public static void main(String[] args) {

    createStreamWithStreamOf();
    createEmptyStreams();
  }

  public static void createStreamWithStreamOf() {

    // It's possible to create manually a stream, if you know beforehand the elements to include
    Stream<String> rainbowColors =
        Stream.of("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet");

    rainbowColors.forEach(System.out::println);
  }

  public static void createEmptyStreams() {
    // Create empty Stream of Strings using Stream class static methods
    // Generic type <String> is inferred;
    Stream<String> emptyStream = Stream.empty();

    Supplier<Stream<String>> supplier = () -> emptyStream;

    if (Streamliner.isStreamEmpty(supplier))
      printBlock(
          "Creating stream using \"Stream.empty()\"",
          Streamliner.stringJoinerByDelimiter(supplier, ", "));
  }
}
