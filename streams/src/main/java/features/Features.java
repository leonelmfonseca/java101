package features;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static utils.DateTimeUtils.sleepForSeconds;

import java.io.IOException;
import java.math.BigInteger;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utils.DataLoaderUtils;

public class Features {

  public static final int START_INCLUSIVE = 1;
  public static final int END_EXCLUSIVE = 3;
  // Create a stream of strings
  private static final Stream<String> wordStream = DataLoaderUtils.getWords().stream();

  private Features() {}

  public static void main(String[] args) throws IOException {
    streamOperationsParticularities();
    System.out.println();
    createSplitFilterSliceStream();
    System.out.println();
    createEmptyStreams();
    System.out.println();
    generateSequenceStream();
    System.out.println();
    createStringLinebreaksStream();
    System.out.println();
    createPatternFilterSliceStream();
    System.out.println();
    createScannerStream();
    System.out.println();
    createStreamWithBuilderPattern();

  }

  private static void createRainbowColorsStream() {

    // It's possible to create manually a stream, if you know beforehand the elements to include
    Stream<String> rainbowColors =
        Stream.of("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet");
  }

  private static void createEmptyStreams() {

    // Create empty Stream of Strings using Stream class static methods
    // Generic type <String> is inferred;
    Stream<String> emptyStream = Stream.empty();
    // or
    Stream<String> yetAnotherEmptyStream = Stream.<String>empty();
  }

  private static void generateStreamRandoms() {

    Stream<Double> randoms = Stream.generate(Math::random);

    // Be carefully, limit is paramount to avoid heap memory depletion/execution
    randoms.limit(5).forEach(System.out::println);
  }

  private static void createStringLinebreaksStream() {

    String todoList =
        "Complete the project report by Friday\nSchedule team meeting for next week\nReview pull requests\nUpdate documentation for the software release\nPrepare presentation for the client meeting on Thursday";

    Stream<String> todoListLines = todoList.lines();

    todoListLines.forEach(System.out::println);
  }

  private static void generateSequenceStream() {

    StringBuilder sequenceStringBuilder = new StringBuilder();
    // Create a stream where each element is the sum of the previous two elements
    Stream.iterate(
            new BigInteger[] {BigInteger.ZERO, BigInteger.ONE},
            arr -> new BigInteger[] {arr[1], arr[0].add(arr[1])})
        .limit(20) // Limit the stream to the first 20 elements
        .map(arr -> arr[0]) // Extract the current value
        .forEach(fibonacciNumber -> sequenceStringBuilder.append(fibonacciNumber).append(SPACE));

    System.out.println(sequenceStringBuilder);
  }

  private static void streamOperationsParticularities() {

    try {
      /*
          Terminal operations (e.g., collect, forEach, reduce) close the stream.
          After a terminal operation, the stream cannot be reused.
          To process the same data again, you need to create a new stream.
      */

      // Apply multiple intermediate operations
      List<String> result =
          wordStream
              .filter(
                  word -> word.length() > 30) // Filter words with names longer than 30 characters
              .map(String::toUpperCase) // Convert each word name to uppercase
              .sorted() // Sort the words alphabetically
              // It's the terminal operation that forces the execution of the lazy operations that
              // precede it.
              .toList();
      System.out.println(result);

      System.out.println("Trying to reuse stream: " + wordStream.count());
    } catch (IllegalStateException e) {
      System.out.println(
          "After a terminal operation to produce a result, the stream can no longer be used.");
    }
  }

  private static void createPatternFilterSliceStream() {

    StringBuilder sb = new StringBuilder();

    // Generate random strings
    sb.append(UUID.randomUUID().toString().concat("-").concat(UUID.randomUUID().toString()));
    System.out.println("Original string: " + sb.toString());

    Stream<String> textSlices = Pattern.compile("\\PL+").splitAsStream(sb.toString());

    // Reset StringBuilder
    sb.setLength(0);

    textSlices.forEach(val -> sb.append(val).append(SPACE));
    System.out.println("Text values: " + sb.toString());
  }

  private static void createSplitFilterSliceStream() {

    StringBuilder sb = new StringBuilder();

    // Generate random strings
    sb.append(UUID.randomUUID().toString().concat("-").concat(UUID.randomUUID().toString()));
    System.out.println("Original string: " + sb.toString());

    // Extract just number and remove empty strings
    String[] numericValues =
        Arrays.stream(sb.toString().split("\\D+")).filter(s -> !s.isEmpty()).toArray(String[]::new);

    System.out.println("Numeric extraction: " + String.join(" ", numericValues));

    if (numericValues.length > END_EXCLUSIVE) {

      Stream<String> filterSliceStream =
          Arrays.stream(numericValues, START_INCLUSIVE, END_EXCLUSIVE);
      System.out.println("Final result: " + filterSliceStream.collect(Collectors.joining(" ")));
    }
  }

  private static void infiniteStreamCreation() {
    // DateTimeFormatter to format the date-time output
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Generate an unbounded, non-reusable stream of status updates
    Stream<String> statusStream = Stream.generate(() -> generateStockMarketsCurrTime(formatter));

    // Limit the stream to the first 5 status updates, print them, and sleep for 2 seconds between
    // updates
    statusStream
        .limit(5)
        .forEach(
            status -> {
              System.out.println(status);
              sleepForSeconds(2);
            });
  }

  private static String generateStockMarketsCurrTime(DateTimeFormatter formatter) {
    return "Current time in major stock markets:\n"
        + "New York: "
        + ZonedDateTime.now(ZoneId.of("America/New_York")).format(formatter)
        + "\n"
        + "London: "
        + ZonedDateTime.now(ZoneId.of("Europe/London")).format(formatter)
        + "\n"
        + "Tokyo: "
        + ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).format(formatter)
        + "\n"
        + "Shanghai: "
        + ZonedDateTime.now(ZoneId.of("Asia/Shanghai")).format(formatter)
        + "\n"
        + "Sydney: "
        + ZonedDateTime.now(ZoneId.of("Australia/Sydney")).format(formatter)
        + "\n";
  }

  private static void createScannerStream() {
    String text =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    // Use try-with-resources to ensure the scanner is closed automatically
    try (Scanner scanner = new Scanner(text)) {

      // Use the Scanner's tokens method to get a stream of words
      Stream<String> words = scanner.tokens();

      StringBuilder builder = new StringBuilder();

      // Process the stream (e.g., filter empty strings)
      words
          .filter(word -> !word.isEmpty()) // Filter out any empty strings
          .forEach(
              word -> {
                builder.append(word).append(SPACE);
              });

      System.out.println(builder.toString());

      // The scanner will be automatically closed here
    }
  }

  private static void createStreamWithBuilderPattern() {
    Stream.Builder<String> builder =
            Stream.builder();
      builder.add("Orion").add("Cassiopeia").add("Ursa Major").add("Scorpius").add("Draco");

    Stream constellations = builder.build();

    StringBuilder sb = new StringBuilder();

    constellations.forEach(constellation -> sb.append(constellation).append(SPACE));
    System.out.println(sb);

  }
}
