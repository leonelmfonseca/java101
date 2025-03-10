package randomizer;


import com.devskiller.jfairy.Fairy;
import java.util.List;
import java.util.stream.IntStream;

public class Randomizer {
    private static final Fairy fairy = Fairy.create();
    // This is a utility method to generate a list of different words
    public static List<String> generateUniqueWords(int count) {

        return IntStream.range(0, count)
                .mapToObj(i -> fairy.textProducer().word(1)).toList();
    }

    private Randomizer() {}
}
