package features;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Features {

  // Create a stream of strings
  static Stream<String> planetStream =
      Stream.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");

  public static void main(String[] args) {

    streamCannotBeReused();
  }

  private static void streamCannotBeReused() {
    try {
      /*
          Terminal operations (e.g., collect, forEach, reduce) close the stream.
          After a terminal operation, the stream cannot be reused.
          To process the same data again, you need to create a new stream.
      */

      // Apply multiple intermediate operations
      List<String> result = planetStream
              .filter(planet -> planet.length() > 5)  // Filter planets with names longer than 5 characters
              .map(String::toUpperCase)               // Convert each planet name to uppercase
              .sorted()                               // Sort the planets alphabetically
              // It's the terminal operation that forces the execution of the lazy operations that precede it.
              .toList();
      System.out.println(result);

      System.out.println("Trying to reuse stream: " + planetStream.count());
    } catch (IllegalStateException e) {
      System.out.println(
          "After a terminal operation to produce a result, the stream can no longer be used.");
    }
  }
}
