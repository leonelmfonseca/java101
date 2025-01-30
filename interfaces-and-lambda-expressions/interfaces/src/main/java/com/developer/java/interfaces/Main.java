package com.developer.java.interfaces;

public class Main {

  public static void main(String[] args) {

    SquareSequence squareSequence = new SquareSequence();
    NumberSequence numberSequence = new NumberSequence(1223245674);

    double avg = average(squareSequence, 100);
    double acmeDouble = average(numberSequence, 100);

    System.out.println(avg);
    System.out.println();
    System.out.println(acmeDouble);
    System.out.println();
    PartialImplementedSequence.partialInterfaceImplementation();


    // Sequence variables reference objects of any implementing class.
    // You can assign objects to interface-type variables or use them in related methods.
    // Interface types can be declared, but actual objects must be of concrete classes.
    Sequence sequence = new NumberSequence(853987);
  }

  public static double average(Sequence seq, int n) {
    int count = 0;
    double sum = 0;

    if (n > 100) {
      return Integer.MAX_VALUE;
    }

    while (seq.hasNext() && count < n) {
      count++;
      sum += seq.next();
    }
    return count == 0 ? 0 : sum / count;
  }
}
