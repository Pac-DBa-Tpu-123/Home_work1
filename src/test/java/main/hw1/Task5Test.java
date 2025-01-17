package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    // Проверяет, что метод возвращает true для однозначных чисел, так как они являются палиндромами
    @Test
    public void testIsPalindromeDescendantSingleDigit() {
        assertTrue(Task5.isPalindromeDescendant(1));
        assertTrue(Task5.isPalindromeDescendant(9));
    }

    // Проверяет, что метод возвращает true для многозначных палиндромов
    @Test
    public void testIsPalindromeDescendantMultiDigit() {
        assertTrue(Task5.isPalindromeDescendant(121));
        assertTrue(Task5.isPalindromeDescendant(12321));
    }

    // Проверяет, что метод возвращает false для непалиндромов
    @Test
    public void testIsPalindromeDescendantNonPalindrome() {
        assertTrue(Task5.isPalindromeDescendant(123));
        assertTrue(Task5.isPalindromeDescendant(12345));
    }
}
