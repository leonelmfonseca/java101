package com.developer.java.interfaces.conversion;

import com.developer.java.interfaces.NumberSequence;
import com.developer.java.interfaces.Sequence;
import com.developer.java.interfaces.SquareSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.developer.java.output.Printing.print;

public class Instanceof {

  /*
  To prevent "cast" exceptions, first we verify that the object belongs to the expected type,
  using the instanceof operator. This ensures safe type casting and avoids runtime errors.
  This approach helps maintain code stability by preventing ClassCastException.
  */

  private static final List<Sequence> sequenceList =
      new ArrayList<>(Arrays.asList(new SquareSequence(), new NumberSequence(654363)));

  public static void main(String[] args) {
     // In Java 16+, pattern matching for instanceof simplifies type checking by automatically casting
    // and assigning the variable in a single step.
    for (Sequence sequence : sequenceList){
      if (sequence instanceof SquareSequence squareSequence){
        squareSequence.whoAmI();
      }
      if (sequence instanceof NumberSequence numberSequence){
        numberSequence.printCurrentNumber();
      }
    }

  }
}
