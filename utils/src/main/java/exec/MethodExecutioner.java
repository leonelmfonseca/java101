package exec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

public class MethodExecutioner {

    public static <T, R> Map<T, R> executeNTimes(Function<T, R> method, int times, List<T> inputs) {
        Map<T, R> cache = new HashMap<>();
        IntStream.range(0, times).forEach(iteration ->
                inputs.forEach(input -> cache.computeIfAbsent(input, method))
        );
        return cache;
    }

    public static long measureExecutionTime(Runnable task) {
        long startTime = System.currentTimeMillis(); // Start time
        // Execute the task
        task.run();
        long endTime = System.currentTimeMillis(); // End time
        return endTime - startTime; // Duration in milliseconds
    }
}
