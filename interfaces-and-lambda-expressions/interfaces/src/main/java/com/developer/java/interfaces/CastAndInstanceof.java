package com.developer.java.interfaces;

import static com.developer.java.output.Printing.print;

public class CastAndInstanceof {

  public static void main(String[] args) {
    Sequence sequence = new NumberSequence(345);

    /*
     Sometimes, you need to convert from a parent type (supertype) to a child type (subtype).
     This is when you use a cast. Casting is required when a method exists only in the subclass
     and not in the interface.
     WARNING: When the subtype of an object is unknown, type-related errors - incompatible types - can occur.
    */
    NumberSequence numberSequence = (NumberSequence) sequence;
    print(String.valueOf(numberSequence.IShallReturnCurrentNumberValue()), 2);

  }
}
