package features;


import static com.developer.java.output.Printing.printHeaderLn;
import static com.developer.java.output.Printing.print;
import static com.developer.java.output.Printing.printBlock;
import static com.developer.java.output.Printing.printOneLine;
import static com.developer.java.output.Streamliner.stringJoinerByDelimiter;
import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.SPACE;

import com.developer.java.output.Printing;
import com.developer.java.output.Streamliner;

import java.math.BigInteger;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamInitialization {
  
  private static final Random random = new Random();
  public static void main(String[] args) {

    createStreamWithStreamOf();
    createEmptyStreams();
    createInfiniteStreams();
    createAndSliceStream();
    createScannerStream();
    generateSequenceStream();
    generateRandomDoublesStream();
  }

  public static void createStreamWithStreamOf() {

    // It's possible to create manually a stream, if you know beforehand the elements to include
    Stream<String> rainbowColors =
        Stream.of("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet");

    rainbowColors.forEach(out::println);
  }

  public static void createEmptyStreams() {
    // Create empty Stream of Strings using Stream class static methods
    Stream<String> emptyStream = Stream.empty();

    Supplier<Stream<String>> supplier = () -> emptyStream;
    String simpleString="";
    simpleString = Streamliner.stringJoinerByDelimiter(supplier, ", ");
    if (Streamliner.isStreamEmpty(supplier)) {
      simpleString = Streamliner.stringJoinerByDelimiter(supplier, ", ");

      printBlock("Creating stream using \"Stream.empty()\"", simpleString);
      }
  }

  public static void createInfiniteStreams() {
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
              out.println(status);
              try {
                TimeUnit.SECONDS.sleep(2);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });
  }

  public static void createAndSliceStream() {
    
    printHeaderLn("Create and slicing stream");
    StringBuilder sb = new StringBuilder();

    // Generate randomizer strings
    sb.append(UUID.randomUUID().toString().concat("-").concat(UUID.randomUUID().toString()));
    out.println("Original string: " + sb.toString());

    // Extract just number and remove empty strings
    String[] numericValues =
        Arrays.stream(sb.toString().split("\\D+")).filter(s -> !s.isEmpty()).toArray(String[]::new);

    out.println("Numeric extraction: " + String.join("  ", numericValues));
    
    
    int maxIdx = random.nextInt(0,numericValues.length);
    int minIdx = random.nextInt(0,maxIdx);


      Stream<String> filterSliceStream =
          Arrays.stream(numericValues, minIdx, maxIdx);
      printOneLine(
          String.format(
              "Numbers from position %d to position %d", minIdx+1, maxIdx), stringJoinerByDelimiter(() -> filterSliceStream, ", "));
      
    
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
  
  public static void createScannerStream() {
    
    printHeaderLn("Create stream using java.util.Scanner");
    
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
              .forEach(word -> builder.append(word).append(SPACE));
      
      out.println(builder.toString());
      
      // The scanner will be automatically closed here
    }
  }
  
  public static void generateRandomDoublesStream() {
    
    printHeaderLn("Create a infinite stream of random doubles");
    Stream<Double> randoms = Stream.generate(Math::random);
    
    // Be carefully, limit is paramount to avoid heap memory depletion/execution
    randoms.limit(5).forEach(out::println);
  }
  
  public static void generateSequenceStream() {
    
    printHeaderLn("Generate infinite sequence stream using Stream::iterate");
    StringBuilder sequenceStringBuilder = new StringBuilder();
    // Create a stream where each element is the sum of the previous two elements
    Stream.iterate(
            new BigInteger[] {BigInteger.ZERO, BigInteger.ONE},
            arr -> new BigInteger[] {arr[1], arr[0].add(arr[1])})
            // WARNING: BY NOT LIMITING THE SIZE OF THE SEQUENCE
            // YOU WILL FIND YOURSELF IN AN INFINITE LOOP
        .limit(20)
        .map(arr -> arr[0]) // Extract the current value
        .forEach(fibonacciNumber -> sequenceStringBuilder.append(fibonacciNumber).append(SPACE));

    print(String.valueOf(sequenceStringBuilder));
  }
  
  public static void createStreamFromStreamWithLinebreaks() {
    
    printHeaderLn("Create a stream from string with linebreaks");
    
    String todoList =
            "Complete the project report by Friday\nSchedule team meeting for next week\nReview pull requests\nUpdate documentation for the software release\nPrepare presentation for the client meeting on Thursday";
    
    Stream<String> todoListLines = todoList.lines();
    
    print("My todo list");
    todoListLines.map(t->"- "+t).forEach(Printing::print);
  }
  
  public static void createStreamFilterWithPattern() {
    
    printHeaderLn("Create a stream and filter it using regex Pattern");
    
    StringBuilder sb = new StringBuilder();
    
    // Generate randomizer strings
    sb.append(UUID.randomUUID().toString().concat("-").concat(UUID.randomUUID().toString()));
    printOneLine("Original string", sb.toString());
    
    
    Stream<String> textSlices = Pattern.compile("\\PL+").splitAsStream(sb.toString());
    
    // Reset StringBuilder
    sb.setLength(0);
    
    textSlices.forEach(val -> sb.append(val).append(SPACE));
    printOneLine("Text values", sb.toString());
  }
  
  
  public static void createStreamUsingBuilderPattern() {
    
    printHeaderLn("Create a stream using Builder Design Pattern");
    
    Stream.Builder<String> builder = Stream.builder();
    builder.add("Orion").add("Cassiopeia").add("Ursa Major").add("Scorpius").add("Draco");
    
    Stream<String> constellations = builder.build();
    
    StringBuilder sb = new StringBuilder();
    
    constellations.forEach(constellation -> sb.append(constellation).append(SPACE));
    printOneLine("Constellations", sb.toString());
  }

}
