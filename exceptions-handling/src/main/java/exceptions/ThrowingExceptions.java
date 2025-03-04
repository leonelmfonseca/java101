package exceptions;

import static java.lang.Math.random;

import exceptions.checked.custom.VotingAgeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

// Checked exceptions are checked at compile-time by the Java compiler.
// This means that the compiler ensures that these exceptions are either caught or declared in
// the method signature using the throws' keyword.
public class ThrowingExceptions {

  private static final Integer MIN_VAL = 25;
  private static final Integer MAX_VAL = 50;
  private static final String FILE_PATH_NAME = "checked-exceptions.txt";

  // VotingAgeException is declared in the method signature, which means that any code that calls
  // this method must either handle the VotingAgeException or also declare it in its own method
  // signature.
  public static void main(String[] args) throws VotingAgeException, IOException {

    System.out.println("\nArithmetic Exception:");
    System.out.println("This: randomInteger("+ MIN_VAL + ", "+ MAX_VAL + ") won't trigger an exception");
    Integer legalArgument = randomInteger(MIN_VAL, MAX_VAL);

    System.out.println("But this: randomInteger("+ MIN_VAL + ", "+ MAX_VAL + ") will!");
    Integer illegalArgument = randomInteger(MIN_VAL, 0);
    try {
      // This method call, will throw a unmanaged, unchecked exception:
      // 'java.lang.ArithmeticException'
      divideByZero(1, 0);
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    }
    try {
      System.out.println("\nCustom Exception:");
      validateVoterAge(15);
    } catch (VotingAgeException e) {
      /*
        In Java, exceptions are designed to "bubble up" the call stack if not caught and handled within the method where they occurred.
        For instance, consider the validateVoterAge method if this method throws an exception and does not catch it,
        the exception will propagate up to the next method that called validateVoterAge.

        If no such handler exists anywhere in the call stack, the application will halt abruptly,
        producing an error message indicating an unhandled exception.
      */
      System.out.println(e.getMessage());
    }

    System.out.println("\nNull Pointer Exception:");

    System.out.println(readFromInputStream());
  }

  public static Integer randomInteger(Integer min, Integer max) {

    Random rand = new Random();
    return ((max - min + 1) + min);
  }

  private static void divideByZero(int numerator, int denominator) {
    // Unchecked Exceptions represent programming errors or unexpected conditions during runtime
    int result = numerator / denominator;
  }

  public static void validateVoterAge(int age) throws VotingAgeException {
    if (age < 18) {
      throw new VotingAgeException("Person must be 18 or older to vote.");
    }
  }

  private static String readFromInputStream() throws IOException {

    InputStream stream =
        ThrowingExceptions.class.getClassLoader().getResourceAsStream(FILE_PATH_NAME);

    StringBuilder resultStringBuilder = new StringBuilder();

    // Unchecked: not checked at compile-time, means that the compiler does not enforce handling of
    // unchecked exceptions.
    // In below code, if stream variable is 'null', an unchecked 'NullPointerException' will be
    // thrown
    try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }

  public static int randMinMax(Integer low, Integer high) {

    if (low > high) {
      throw new IllegalArgumentException(
          "low should be <= high but low is %d and high is %d".formatted(low, high));
    }

    System.out.printf("low  %d and high  %d%n", low, high);

    return low + (int) (random() * (high - low + 1));
  }
}
