package utils;

import java.util.concurrent.TimeUnit;

public class DateTimeUtils {
    public static void sleepForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
    }
}
