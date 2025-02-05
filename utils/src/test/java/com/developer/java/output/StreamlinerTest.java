package com.developer.java.output;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamlinerTest {

  @Test
  void isStreamEmpty() {
    assert Streamliner.isStreamEmpty(Stream::empty);
  }
}
