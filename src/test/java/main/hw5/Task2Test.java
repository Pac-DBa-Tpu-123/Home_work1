package main.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testFindFriday13s() {
        List<LocalDate> expectedFriday13s2024 = Arrays.asList(
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        );
        List<LocalDate> actualFriday13s2024 = Task2.findFriday13s(2024);
        assertEquals(expectedFriday13s2024, actualFriday13s2024);

        List<LocalDate> expectedFriday13s1925 = Arrays.asList(
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13)
        );
        List<LocalDate> actualFriday13s1925 = Task2.findFriday13s(1925);
        assertEquals(expectedFriday13s1925, actualFriday13s1925);
    }

    @Test
    public void testFindNextFriday13() {
        LocalDate startDate = LocalDate.of(2023, 10, 1);
        LocalDate expectedNextFriday13 = LocalDate.of(2024, 9, 13);
        LocalDate actualNextFriday13 = Task2.findNextFriday13(startDate);
        assertEquals(expectedNextFriday13, actualNextFriday13);

        startDate = LocalDate.of(2024, 12, 14);
        expectedNextFriday13 = LocalDate.of(2025, 6, 13);
        actualNextFriday13 = Task2.findNextFriday13(startDate);
        assertEquals(expectedNextFriday13, actualNextFriday13);
    }
}
