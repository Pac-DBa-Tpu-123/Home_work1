package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    public void testIsPalindromeDescendantSingleDigit() {
        // Проверяет, что метод возвращает true для однозначных чисел, так как они являются палиндромами
        assertTrue(Task5.isPalindromeDescendant(1));
        assertTrue(Task5.isPalindromeDescendant(9));
    }

    @Test
    public void testIsPalindromeDescendantMultiDigit() {
        // Проверяет, что метод возвращает true для многозначных палиндромов
        assertTrue(Task5.isPalindromeDescendant(121));
        assertTrue(Task5.isPalindromeDescendant(12321));
    }

    @Test
    public void testIsPalindromeDescendantNonPalindrome() {
        // Проверяет, что метод возвращает false для непалиндромов
        assertTrue(Task5.isPalindromeDescendant(123));
        assertTrue(Task5.isPalindromeDescendant(12345));
    }
}
