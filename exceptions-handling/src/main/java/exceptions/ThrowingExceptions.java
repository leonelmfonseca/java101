package exceptions;

import static java.lang.Math.random;

import java.util.Random;

public class ThrowingExceptions {

  private static final Integer MIN_VAL = 25;
  private static final Integer MAX_VAL = 50;

  public static void main(String[] args) {

    System.out.println("This won't trigger an exception");
    Integer legalArgument = randomInteger(MIN_VAL, MAX_VAL);

    System.out.println("But this will!");
    Integer illegalArgument = randomInteger(MIN_VAL, 0);


  }

  public static int randMinMax(Integer low, Integer high) {

    if (low > high) {
      throw new IllegalArgumentException(
          "low should be <= high but low is %d and high is %d".formatted(low, high));
    }

    System.out.println("low  %d and high  %d".formatted(low, high));

    return low + (int) (random() * (high - low + 1));
  }

  public static Integer randomInteger(Integer min, Integer max) {

    Random rand = new Random();
    return ((max - min + 1) + min);
  }
  }
