package com.developer.java.interfaces;

import static com.developer.java.output.Printing.print;

// The implements keyword signifies that the SquareSequence class is designed to adhere to the
// contract
// specified by the Sequence interface.
public class SquareSequence implements Sequence {

  private int i;

  /*
   • @Override is an optional Java annotation, but a must for good code.
   • It tells the compiler "I intend to override a superclass method."
   • This prevents typos from creating new methods instead, catching errors early.
   • It also makes your code much easier to read by clearly showing which methods are overridden.
   • Use it—it's a small thing that makes a big difference.
  */
  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public int next() {
    i++;
    return i * i;
  }

  // This is a class method, it's not declared in the interface
  public void whoAmI() {
    print("I'm the square sequence");
  }

}
