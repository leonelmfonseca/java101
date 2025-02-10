package com.developer.java.fundamentals.copy;

public class DeepyCopy {

  public static void main(String[] args) {
    
    System.out.println("Take into consideration that Mustang T5 and Mustang GT5 are the same.");
    System.out.println();
    Car mustangT5 = new Car("Mustang T5", new Engine("EcoBoost", 330, 350));
    Car mustangGT5 = Car.deepCopy(mustangT5);
    
    System.out.println("Mustang T5:" + mustangT5);
    System.out.println("Mustang GT5:" + mustangGT5);
    System.out.println();
    System.out.println(
        "'hashcode' is used to provide a unique integer for efficient storage and retrieval in hash-based collections.");
    System.out.println(
        "Both objects hashcode are equal when their fields are identical.");
    System.out.println(
            "Mustang T5 hashcode="
                    + mustangT5.hashCode());
    System.out.println(
        "Mustang GT5 hashcode="
            + mustangGT5.hashCode());

    System.out.println();

    System.out.println("'equals' defines logical equality based on object attributes");
    System.out.println(
        "The Mustang T5 and Mustang GT5 are equal because they're attributes are identical.");
    System.out.println(
        "Mustang T5 is "
            + (mustangT5.equals(mustangGT5) ? "equal" : "different")
            + " to Mustang GT5");
    System.out.println();
    
    System.out.println("But they aren't the same object:\nMustang T5 memory addr: " + mustangT5.getMemoryAddress() + "\nMustang GT5 memory addr:" + mustangGT5.getMemoryAddress());
    
    System.out.println();
    Engine newEngine = new Engine("5.0-liter V8 engine", 1400, 1100);
    System.out.println("Let's change Mustang T5 engine from :"+ mustangT5.getEngine().toString() + " to " + newEngine.toString() + " and see what " +
            "happens" +
            "..");
    mustangT5.setEngine(newEngine);
    System.out.println();
    System.out.println("Mustang T5:" + mustangT5);
    System.out.println("Mustang GT5:" + mustangGT5);
    System.out.println();
    System.out.println("Thanks to deep copy strategy , we replace mustang engine, without affecting the Mustang GT5 engine, because, they are" +
            " " +
            "diff instances of class Car as" +
            " well as they're Engine objects.");
  }
}
