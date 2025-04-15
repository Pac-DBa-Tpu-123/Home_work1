package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

public class Task3Test {

    @Test
    public void FixedFormats() {
        assertEquals(Optional.of(LocalDate.of(2023, 10, 7)), Task3.parseDate("2023-10-07"));
        assertEquals(Optional.of(LocalDate.of(2023, 10, 7)), Task3.parseDate("2023-10-7"));
        assertEquals(Optional.of(LocalDate.of(2023, 10, 7)), Task3.parseDate("10/7/2023"));
        assertEquals(Optional.of(LocalDate.of(2023, 10, 7)), Task3.parseDate("10/7/23"));
    }

    @Test
    public void VerbalDates() {
        LocalDate today = LocalDate.now();
        assertEquals(Optional.of(today), Task3.parseDate("today"));
        assertEquals(Optional.of(today.plusDays(1)), Task3.parseDate("tomorrow"));
        assertEquals(Optional.of(today.minusDays(1)), Task3.parseDate("yesterday"));
    }

    @Test
    public void DaysAgo() {
        LocalDate today = LocalDate.now();
        assertEquals(Optional.of(today.minusDays(1)), Task3.parseDate("1 day ago"));
        assertEquals(Optional.of(today.minusDays(5)), Task3.parseDate("5 days ago"));
        assertEquals(Optional.of(today.minusDays(10)), Task3.parseDate("10 days ago"));
    }

    @Test
    public void InvalidDates() {
        assertTrue(Task3.parseDate("").isEmpty());
        assertTrue(Task3.parseDate(null).isEmpty());
        assertTrue(Task3.parseDate("invalid date").isEmpty());
        assertTrue(Task3.parseDate("2023-13-01").isEmpty());
        assertTrue(Task3.parseDate("2023-05-45").isEmpty());
    }

    @Test
    public void RegisteredDates() {
        LocalDate today = LocalDate.now();
        assertEquals(Optional.of(today), Task3.parseDate("TODAY"));
        assertEquals(Optional.of(today.plusDays(1)), Task3.parseDate("ToMoRrOw"));
        assertEquals(Optional.of(today.minusDays(1)), Task3.parseDate("YeStErDaY"));
        assertEquals(Optional.of(today.minusDays(5)), Task3.parseDate("5 DaYs AgO"));
    }
}
