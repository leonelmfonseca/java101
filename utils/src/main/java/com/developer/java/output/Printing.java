package com.developer.java.output;

import java.util.Arrays;

import static java.lang.System.*;

public class Printing {

  public static final String EQUALS_SEPARATOR =
      "==================================================";

  private static final int DEFAULT_LINEBREAK_COUNT = 1;

  public static void printOneLine(String name, String message) {
    print(name + ": " + message);
  }

  public static void print(String message) {
    out.println(message);
  }

  public static void printLn(String... strings) {
    Arrays.stream(strings).forEach(Printing::printLn);
  }

  public static void printLn(String message) {
    print(message, DEFAULT_LINEBREAK_COUNT, DEFAULT_LINEBREAK_COUNT);
  }

  public static void print(String message, int aboveLnBreaks, int belowLnBreaks) {
    String builder =
        String.valueOf(lineSeparator()).repeat(Math.max(0, aboveLnBreaks))
            + message
            + String.valueOf(lineSeparator()).repeat(Math.max(0, belowLnBreaks));
    print(builder);
  }

  public static void printBlock(String header, String singleLine) {
    printHeaderLn(header);
    print(singleLine, 0, 1);
  }

  public static void printHeaderLn(String header) {
    out.println();
    print(header);
    print(EQUALS_SEPARATOR);
  }
  
  public static void print(String header, int aboveLnBreaks) {
  
  }
}
