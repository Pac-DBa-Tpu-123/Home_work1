package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

    // Проверяет, что метод корректно меняет местами символы в строке четной длины
    @Test
    public void testFixStringEvenLength() {
        assertEquals("abcdef", Task4.fixString("badcfe"));
        assertEquals("123456", Task4.fixString("214365"));
    }

    // Проверяет, что метод корректно меняет местами символы в строке нечетной длины
    @Test
    public void testFixStringOddLength() {
        assertEquals("abcde", Task4.fixString("badce"));
        assertEquals("12345", Task4.fixString("21435"));
    }

    // Проверяет, что метод корректно обрабатывает строку, содержащую один символ
    @Test
    public void testFixStringSingleCharacter() {
        assertEquals("a", Task4.fixString("a"));
        assertEquals("1", Task4.fixString("1"));
    }

    // Проверяет, что метод корректно обрабатывает пустую строку
    @Test
    public void testFixStringEmptyString() {
        assertEquals("", Task4.fixString(""));
    }

    // Проверяет, что метод корректно меняет местами символы в строке, содержащей смешанные символы
    @Test
    public void testFixStringMixedCharacters() {
        assertEquals("1a2b3", Task4.fixString("a1b23"));
        assertEquals("1a2b3c", Task4.fixString("a1b2c3"));
    }
}
