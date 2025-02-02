package main.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;

public class Task3Test {

    @Test
    public void testFreqDictWithStrings() {
        Map<String, Integer> expected = Map.of("a", 2, "bb", 2);
        Map<String, Integer> actual = Task3.freqDict(List.of("a", "bb", "a", "bb"));
        assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithWords() {
        Map<String, Integer> expected = Map.of("that", 1, "and", 2, "this", 1);
        Map<String, Integer> actual = Task3.freqDict(List.of("this", "and", "that", "and"));
        assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithRussianWords() {
        Map<String, Integer> expected = Map.of("код", 3, "bug", 1);
        Map<String, Integer> actual = Task3.freqDict(List.of("код", "код", "код", "bug"));
        assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithIntegers() {
        Map<Integer, Integer> expected = Map.of(1, 2, 2, 2);
        Map<Integer, Integer> actual = Task3.freqDict(List.of(1, 1, 2, 2));
        assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithEmptyList() {
        Map<String, Integer> expected = Map.of();
        Map<String, Integer> actual = Task3.freqDict(List.of());
        assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithSingleElement() {
        Map<String, Integer> expected = Map.of("a", 1);
        Map<String, Integer> actual = Task3.freqDict(List.of("a"));
        assertEquals(expected, actual);
    }
}
