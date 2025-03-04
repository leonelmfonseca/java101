package com.developer.java;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
If enum is reused intensively, and has a considerable number of values, use unmodifiableList
Be wise when choosing the best approach for your use case.
*/
public class EnumerationCache {
  
  static final Iterable<WorldCapital> worldCapitalList = List.of(WorldCapital.values());
  
  static final com.developer.java.cache.EnumCache<String, WorldCapital> cacheFromList =
          new com.developer.java.cache.EnumCache<>(worldCapitalList, WorldCapital::getCountryName);

  public static void main(String[] args) {
    // Supply an array structure with enum values to cache object
    // It's initialized once, and the values and ordinals pass to a cache object
    ChronoUnit[] monthsArray = ChronoUnit.values();
    
    com.developer.java.cache.EnumCache<Integer, ChronoUnit> cacheFromArray =
            new com.developer.java.cache.EnumCache<>(Arrays.asList(monthsArray), ChronoUnit::ordinal);
    
    System.out.println("Builtin enum cache:"+ cacheFromArray);
    
    System.out.println("Custom enum cache:"+ cacheFromArray);
    for (Map.Entry<String, WorldCapital> entry : cacheFromList.getCache().entrySet()) {
      System.out.println(entry.getValue().toString());
    }
    
    
  }
}
