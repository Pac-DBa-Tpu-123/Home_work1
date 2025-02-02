package main.hw3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task7Test {

    private Task7 task7;

    @BeforeEach
    public void setUp() {
        task7 = new Task7();
    }

    @Test
    public void testPutAndGet() {
        task7.put("key1", "value1");
        assertEquals("value1", task7.get("key1"));
    }

    @Test
    public void testContainsKey() {
        task7.put("key2", "value2");
        assertTrue(task7.containsKey("key2"));
        assertFalse(task7.containsKey("key3"));
    }

    @Test
    public void testNullKey() {
        task7.put(null, "test");
        assertTrue(task7.containsKey(null));
        assertEquals("test", task7.get(null));
    }

    @Test
    public void testNullValue() {
        task7.put("key4", null);
        assertTrue(task7.containsKey("key4"));
        assertEquals(null, task7.get("key4"));
    }

    @Test
    public void testMultipleEntries() {
        task7.put("key5", "value5");
        task7.put("key6", "value6");
        assertTrue(task7.containsKey("key5"));
        assertTrue(task7.containsKey("key6"));
        assertEquals("value5", task7.get("key5"));
        assertEquals("value6", task7.get("key6"));
    }

    @Test
    public void testOverwriteValue() {
        task7.put("key7", "value7");
        task7.put("key7", "newValue7");
        assertEquals("newValue7", task7.get("key7"));
    }
}
