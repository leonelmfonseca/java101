package com.developer.java.output;

import static com.developer.java.output.Streamliner.countStreamElems;
import static java.time.DayOfWeek.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devskiller.jfairy.Fairy;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devskiller.jfairy.producer.person.Person;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

class StreamlinerTest {

  @Test
  void testIsStreamEmpty() {
    assert Streamliner.isStreamEmpty(Stream::empty);
  }

  @Test
  void testStringJoinerByDelimiter() {}
  

  @Test
  void testGetListOfStreamElements() {}

  @Test
  void testIsStreamable() {
  
  }

  @Test
  void testCountStreamElems() {

    List<DayOfWeek> days = List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
    Stream<DayOfWeek> workingDays = days.stream();

    assertEquals(countStreamElems(() -> workingDays), days.size());
    
  }
}
