package com.developer.java.interfaces;

import static com.developer.java.output.Printing.printOneLine;

public class NumberSequence implements Sequence {

  private int number;

  public NumberSequence(int number) {
    this.number = number;
  }

  @Override
  public boolean hasNext() {
    // This and the following method are declared in the interface
    return number != 0;
  }

  // Returns each number of the argument starting from units
  @Override
  public int next() {
    int result = number % 10;
    number /= 10;

    return result;
  }

  // This is a class method, it's not declared in the interface
  public void printCurrentNumber() {
    printOneLine("Number Sequence current number", String.valueOf(this.number));
  }
}
