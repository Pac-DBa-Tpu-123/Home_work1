package main.hw5;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    public void testCalculateAverageSessionTime() {
        List<String> sessions = Arrays.asList(
            "2023-10-01, 10:00 - 2023-10-01, 12:00",
            "2023-10-01, 14:00 - 2023-10-01, 16:00",
            "2023-10-01, 18:00 - 2023-10-01, 20:00"
        );
        Duration expectedAverageDuration = Duration.ofHours(2);
        Duration actualAverageDuration = Task1.calculateAverageSessionTime(sessions);
        assertEquals(expectedAverageDuration, actualAverageDuration);
    }

    @Test
    public void testFormatDuration() {
        Duration duration = Duration.ofHours(3).plusMinutes(45);
        String expectedFormattedDuration = "3ч 45м";
        String actualFormattedDuration = Task1.formatDuration(duration);
        assertEquals(expectedFormattedDuration, actualFormattedDuration);
    }

    @Test
    public void testFormatDurationZeroMinutes() {
        Duration duration = Duration.ofHours(3);
        String expectedFormattedDuration = "3ч 0м";
        String actualFormattedDuration = Task1.formatDuration(duration);
        assertEquals(expectedFormattedDuration, actualFormattedDuration);
    }

    @Test
    public void testFormatDurationZeroHours() {
        Duration duration = Duration.ofMinutes(45);
        String expectedFormattedDuration = "0ч 45м";
        String actualFormattedDuration = Task1.formatDuration(duration);
        assertEquals(expectedFormattedDuration, actualFormattedDuration);
    }
}
