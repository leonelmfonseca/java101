package features;

import org.junit.jupiter.api.Test;

class StreamInitializationTest {

  @Test
  void testCreateStreamWithStreamOf() {}

  @Test
  void testCreateAndSliceStream() {
    StreamInitialization.createAndSliceStream();
  }

  @Test
  void testCreateEmptyStreams() {
    StreamInitialization.createEmptyStreams();
  }
  
  @Test
  void testGenerateRandomDoublesStream() {
    StreamInitialization.generateRandomDoublesStream();
  }
  
  @Test
  void testGenerateSequenceStream() {
    StreamInitialization.generateSequenceStream();
  }

  @Test
  void testCreateStreamFromStreamWithLinebreaks() {
    StreamInitialization.createStreamFromStreamWithLinebreaks();
  }
  
  @Test
  void testCreateStreamFilterWithPattern(){
    StreamInitialization.createStreamFilterWithPattern();
  }
  
  @Test
  void testCreateStreamUsingBuilderPattern(){
    StreamInitialization.createStreamUsingBuilderPattern();
  }
  
}
