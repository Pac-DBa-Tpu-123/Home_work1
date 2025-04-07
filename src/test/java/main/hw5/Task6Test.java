package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {

    @Test
    public void testIsSubsequence() {
        assertTrue(Task6.isSubsequence("abc", "izdvlzijdbvabcsod"));
        assertTrue(Task6.isSubsequence("abc", "abc"));
        assertTrue(Task6.isSubsequence("abc", "aabbcc"));
        assertTrue(Task6.isSubsequence("abc", "aaabbbccc"));
        assertTrue(Task6.isSubsequence("xyz", "xyz"));
        assertTrue(Task6.isSubsequence("xyz", "wxyz"));
        assertTrue(Task6.isSubsequence("xyz", "wxyzw"));
        assertTrue(Task6.isSubsequence("123", "a1b2c3"));
        assertTrue(Task6.isSubsequence("123", "123"));
        assertTrue(Task6.isSubsequence("123", "1a2b3c"));
        assertTrue(Task6.isSubsequence("", "abc"));
        assertTrue(Task6.isSubsequence("", ""));
        assertTrue(Task6.isSubsequence("world", "Hello world!"));
    }

    @Test
    public void testIsSubsequenceFalse() {
        assertFalse(Task6.isSubsequence("abc", "fbvzdvovoskdvn"));
        assertFalse(Task6.isSubsequence("abc", "ab"));
        assertFalse(Task6.isSubsequence("abc", "acb"));
        assertFalse(Task6.isSubsequence("xyz", "xy"));
        assertFalse(Task6.isSubsequence("xyz", "yz"));
        assertFalse(Task6.isSubsequence("123", "12"));
        assertFalse(Task6.isSubsequence("123", "23"));
        assertFalse(Task6.isSubsequence(null, "abc"));
        assertFalse(Task6.isSubsequence("abc", null));
        assertFalse(Task6.isSubsequence("World", "Hello world!"));
    }
}
