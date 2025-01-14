package com.developer.java.custom;

import com.developer.java.cache.EnumCache;
import java.util.List;
import java.util.Map;

/*
If enum is reused intensively, and has a considerable number of values, use unmodifiableList
Be wise when choosing the best approach for your use case.
*/
public class CustomEnumUsingCache {

  static final Iterable<WorldCapital> worldCapitalList = List.of(WorldCapital.values());

  static final EnumCache<String, WorldCapital> cacheFromList =
      new EnumCache<>(worldCapitalList, WorldCapital::getCountryName);

  public static void main(String[] args) {

    for (Map.Entry<String, WorldCapital> entry : cacheFromList.getCache().entrySet()) {
      System.out.println(entry.getValue().toString());
    }
  }
}
