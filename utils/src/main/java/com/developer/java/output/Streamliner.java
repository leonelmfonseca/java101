package com.developer.java.output;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamliner {


  private Streamliner() {}

  public static String stringJoinerByDelimiter(
      Supplier<Stream<String>> wordsSupplier, String delimiter) {
    // Collect elements into a list
    List<String> elements = wordsSupplier.get().toList();
    return elements.stream().map(String::toLowerCase).collect(Collectors.joining(delimiter));
  }

  public static String stringJoinerByDelimiter(List<String> wordList, String delimiter) {

    return wordList.stream().map(String::toLowerCase).collect(Collectors.joining(delimiter));
  }

  public static <T> List<T> getListOfStreamElements(Supplier<Stream<T>> streamSupplier) {
    if (!isStreamEmpty(streamSupplier)) return streamSupplier.get().toList();
    return List.of();
  }

  /*
   Supplier<Stream<T>> is used to create new streams as needed.
   The isStreamEmpty method takes a Supplier<Stream<T>> as an argument.
   The stream is checked for null and emptiness  WITHOUT CONSUMING it.
   This approach ensures that the stream can be reused for downstream operations.
  */
  public static <T> boolean isStreamEmpty(Supplier<Stream<T>> streamSupplier) {
    // Check if the stream is null
    if (streamSupplier == null || streamSupplier.get() == null) {
      return true; // Consider null or non-existent stream as empty
    }
    
    // Use a temporary stream to check for emptiness without consuming the original stream.
    // try-with-resources is paramount. if stream has resources that need to be releases afterward
    try (Stream<T> stream = streamSupplier.get()) {
      return stream.findAny().isEmpty();
    }
  }
  
  public static <T> int countStreamElems(Supplier<Stream<T>> streamSupplier) {
    Stream<T> stream = streamSupplier.get();

    List<T> elements = stream.toList();
    
    return elements.size();
  }
}
