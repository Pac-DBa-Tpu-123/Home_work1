package main.hw3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Task8Test {
    private List<Integer> list;
    private Task8<Integer> iterator;

    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1, 2, 3);
        iterator = new Task8<>(list);
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
    }

    @Test
    public void testNextThrowsException() {
        iterator = new Task8<>(List.of());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}
