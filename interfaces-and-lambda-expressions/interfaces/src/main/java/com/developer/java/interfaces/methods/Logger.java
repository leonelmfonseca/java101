package com.developer.java.interfaces.methods;


import static com.developer.java.output.Printing.*;

import java.time.LocalDateTime;

public interface Logger {

  /*
    Java 8+ allows static methods in interfaces, eliminating the need for separate utility
    classes (e.g., Collections for Collection), making code organization more streamlined and intuitive.
    By default, the access modifier for the static methods in interfaces is public.
    WARNING: Don't forget, private methods can't use private methods, as non-static methods
    cannot be referenced from static context
  */
  static void log(String message) {
    print("[LOG]" + message);
  }

/*
  Private methods in interfaces enhance code reusability, encapsulation, and maintainability,
  similar to their use in classes.
  They allow shared logic to be reused within default methods, hide internal details, and make the code
  more modular and easier to manage.
  This brings interfaces closer to object-oriented programming principles.
*/
  private String getCurrentLocalDateTimeAsString(){
    return String.valueOf(LocalDateTime.now());
  }

  /*
   You can supply a default implementation for any interface method.
   You must tag such a method with the default modifier.
   It is possible to have more than one default method.
  */
  default String getDate() {
    return getCurrentLocalDateTimeAsString();
  }
  /*
     For instance, consider the Logger interface with an added details() method. If details() were a non-default method,
      the existing TimeLogger class would fail to compile because it doesn't implement it, breaking source compatibility.
      However, using an older JAR with TimeLogger would still load successfully due to binary compatibility.
      Invocation of details() on a TimeLogger instance would result in an AbstractMethodError.
      Making details() a default method allows TimeLogger to compile without changes and enables the default
      implementation to be used when called, enhancing stability and adaptability.
  */
}
