package randomizer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomizerTest {

  @Test
  void generateUniqueWords() {
    List<String> uniqueWords = Randomizer.generateUniqueWords(4);

    for (String word : uniqueWords) {
      System.out.println(word);
    }

    assertTrue(true);
  }
}
