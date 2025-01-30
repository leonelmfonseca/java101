package com.developer.java.interfaces;

public abstract class PartialImplementedSequence implements Sequence {
  @Override
  public boolean hasNext() {
    return false;
  }

  public static void partialInterfaceImplementation() {
    System.out.println("I implement Sequence interface, but I'll only use hasNext() method");
    System.out.println(
        "If a class only implements some of the methods, then it\n"
            + "must be declared with the abstract modifier.");
    System.out.println();
  }
}
