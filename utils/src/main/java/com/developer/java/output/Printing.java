package com.developer.java.output;

import java.util.Arrays;

public class Printing {

  public static final String EQUALS_SEPARATOR =
      "==================================================";

  private static final int DEFAULT_LINEBREAK_COUNT = 1;

  public static void printOneLine(String name, String message) {
    print(name + ": " + message);
  }

  public static void print(String message) {
    System.out.println(message);
  }

  public static void printLn(String... strings) {
    Arrays.stream(strings).forEach(Printing::printLn);
  }

  public static void printLn(String message) {
    print(message, DEFAULT_LINEBREAK_COUNT, DEFAULT_LINEBREAK_COUNT);
  }

  public static void print(String message, int aboveLnBreaks, int belowLnBreaks) {
    String builder =
        String.valueOf(System.lineSeparator()).repeat(Math.max(0, aboveLnBreaks))
            + message
            + String.valueOf(System.lineSeparator()).repeat(Math.max(0, belowLnBreaks));
    print(builder);
  }

  public static void printBlock(String header, String singleLine) {
    Printing.printHeaderLn(header);
    Printing.print(singleLine, 0, 1);
  }

  public static void printHeaderLn(String header) {
    System.out.println();
    Printing.print(header);
    Printing.print(EQUALS_SEPARATOR);
  }
}
