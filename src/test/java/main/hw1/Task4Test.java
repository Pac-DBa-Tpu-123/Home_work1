package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

    @Test
    public void testFixStringEvenLength() {
        // Проверяет, что метод корректно меняет местами символы в строке четной длины
        assertEquals("abcdef", Task4.fixString("badcfe"));
        assertEquals("123456", Task4.fixString("214365"));
    }

    @Test
    public void testFixStringOddLength() {
        // Проверяет, что метод корректно меняет местами символы в строке нечетной длины
        assertEquals("abcde", Task4.fixString("badce"));
        assertEquals("12345", Task4.fixString("21435"));
    }

    @Test
    public void testFixStringSingleCharacter() {
        // Проверяет, что метод корректно обрабатывает строку, содержащую один символ
        assertEquals("a", Task4.fixString("a"));
        assertEquals("1", Task4.fixString("1"));
    }

    @Test
    public void testFixStringEmptyString() {
        // Проверяет, что метод корректно обрабатывает пустую строку
        assertEquals("", Task4.fixString(""));
    }

    @Test
    public void testFixStringMixedCharacters() {
        // Проверяет, что метод корректно меняет местами символы в строке, содержащей смешанные символы
        assertEquals("1a2b3", Task4.fixString("a1b23")); // "a1b2c3" -> "b1d2f3"
        assertEquals("1a2b3c", Task4.fixString("a1b2c3")); // "1a3b5c" -> "2a4b6c"
    }
}
