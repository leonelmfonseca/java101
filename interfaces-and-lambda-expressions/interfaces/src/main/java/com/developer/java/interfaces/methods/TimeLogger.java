package com.developer.java.interfaces.methods;


import java.time.ZonedDateTime;

public class TimeLogger implements Logger {
  /*
   A class implementing Logger interface can choose to override the getDate method or to
   inherit the default implementation. Remember, if you override getDate() you will not be able,
   in some case, for some reason, call the interface getDate();
  */

  @Override
  public String getDate() {

    Logger.log("I'm using the static method of the interface that I implement");
    return String.valueOf(ZonedDateTime.now());
  }
}
