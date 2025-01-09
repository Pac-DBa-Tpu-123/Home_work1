package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

    @Test
    // Проверяет, что метод корректно меняет местами символы в строке четной длины
    public void testFixStringEvenLength() {
        assertEquals("abcdef", Task4.fixString("badcfe"));
        assertEquals("123456", Task4.fixString("214365"));
    }

    @Test
    // Проверяет, что метод корректно меняет местами символы в строке нечетной длины
    public void testFixStringOddLength() {
        assertEquals("abcde", Task4.fixString("badce"));
        assertEquals("12345", Task4.fixString("21435"));
    }

    @Test
    // Проверяет, что метод корректно обрабатывает строку, содержащую один символ
    public void testFixStringSingleCharacter() {
        assertEquals("a", Task4.fixString("a"));
        assertEquals("1", Task4.fixString("1"));
    }

    @Test
    // Проверяет, что метод корректно обрабатывает пустую строку
    public void testFixStringEmptyString() {
        assertEquals("", Task4.fixString(""));
    }

    @Test
    // Проверяет, что метод корректно меняет местами символы в строке, содержащей смешанные символы
    public void testFixStringMixedCharacters() {
        assertEquals("1a2b3", Task4.fixString("a1b23"));
        assertEquals("1a2b3c", Task4.fixString("a1b2c3"));
    }
}
