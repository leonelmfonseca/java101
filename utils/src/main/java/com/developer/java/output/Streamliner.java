package com.developer.java.output;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamliner {

  public static final String STANDARD_DELIMITER = ", ";

  private Streamliner() {}

  public static String stringJoinerByDelimiter(Supplier<Stream<String>> wordsSupplier, String delimiter) {
    // Collect elements into a list
    List<String> elements = wordsSupplier.get().toList();
    return elements.stream().map(String::toLowerCase).collect(Collectors.joining(delimiter));
  }

  /*
    Supplier<Stream<T>> is used to create new streams as needed.
    The isStreamable method takes a Supplier<Stream<T>> as an argument.
    The stream is checked for null and emptiness WITHOUT CONSUMING it.
    This approach ensures that the stream can be reused for downstream operations.
   */
  public static <T> boolean isStreamable( Supplier<Stream<T>> streamSupplier) {
    return isStreamEmpty(streamSupplier) && countStreamElems(streamSupplier) > 0;
  }
  
  public static <T> int countStreamElems(Supplier<Stream<T>> streamSupplier) {
    if(isStreamEmpty(streamSupplier)) return -1;
    return Math.toIntExact(streamSupplier.get().count());
  }
  
  public static <T> boolean isStreamEmpty(Supplier<Stream<T>> streamSupplier) {
    return streamSupplier.get().findAny().isEmpty();
  }
}
