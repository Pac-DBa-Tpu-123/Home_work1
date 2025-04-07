package main.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    @Test
    public void testParseDateStandardFormats() {
        assertEquals(Optional.of(LocalDate.of(2020, 10, 10)), Task3.parseDate("2020-10-10"));
        assertEquals(Optional.of(LocalDate.of(2020, 12, 2)), Task3.parseDate("2020-12-2"));
        assertEquals(Optional.of(LocalDate.of(1976, 1, 3)), Task3.parseDate("1/3/1976"));
        assertEquals(Optional.of(LocalDate.of(2020, 1, 3)), Task3.parseDate("1/3/20"));
    }

    @Test
    public void testParseDateRelativeDates() {
        LocalDate today = LocalDate.now();
        assertEquals(Optional.of(today), Task3.parseDate("today"));
        assertEquals(Optional.of(today.plusDays(1)), Task3.parseDate("tomorrow"));
        assertEquals(Optional.of(today.minusDays(1)), Task3.parseDate("yesterday"));
    }

    @Test
    public void testParseDateDaysAgo() {
        LocalDate today = LocalDate.now();
        assertEquals(Optional.of(today.minusDays(1)), Task3.parseDate("1 day ago"));
        assertEquals(Optional.of(today.minusDays(2234)), Task3.parseDate("2234 days ago"));
    }

    @Test
    public void testParseDateInvalidFormat() {
        assertTrue(Task3.parseDate("invalid date").isEmpty());
        assertTrue(Task3.parseDate("").isEmpty());
        assertTrue(Task3.parseDate(null).isEmpty());
    }
}
