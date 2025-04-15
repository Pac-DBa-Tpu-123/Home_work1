package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {

    @Test
    public void TrueCases() {
        assertTrue(Task6.isSubsequence("abc", "dfabcke"));
        assertTrue(Task6.isSubsequence("abc", "abcd"));
        assertTrue(Task6.isSubsequence("abc", "abcdef"));
        assertTrue(Task6.isSubsequence("abc", "123abc456"));
        assertTrue(Task6.isSubsequence("", "abcd")); // Пустая строка является подстрокой любой строки
    }

    @Test
    public void FalseCases() {
        assertFalse(Task6.isSubsequence("abc", "abd"));
        assertFalse(Task6.isSubsequence("abc", "def"));
        assertFalse(Task6.isSubsequence("abc", "")); // Непустая строка не является подстрокой пустой строки
        assertFalse(Task6.isSubsequence(null, "abcd")); // null не является допустимым значением
        assertFalse(Task6.isSubsequence("abc", null)); // null не является допустимым значением
    }

    @Test
    public void EdgeCases() {
        assertTrue(Task6.isSubsequence("a", "a"));
        assertTrue(Task6.isSubsequence("a", "ab"));
        assertTrue(Task6.isSubsequence("a", "ba"));
        assertFalse(Task6.isSubsequence("ab", "a"));
        assertFalse(Task6.isSubsequence("ab", "b"));
    }

    @Test
    public void testIsSubsequence_SpecialCharacters() {
        assertTrue(Task6.isSubsequence("a.b", "a.b"));
        assertTrue(Task6.isSubsequence("a.b", "123a.b456"));
        assertTrue(Task6.isSubsequence("a*b", "a*b"));
        assertTrue(Task6.isSubsequence("a*b", "123a*b456"));
        assertFalse(Task6.isSubsequence("a.b", "ab"));
        assertFalse(Task6.isSubsequence("a*b", "ab"));
    }
}
