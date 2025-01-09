package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {

    @Test
    public void testCountDigitsZero() {
        // Проверяет, что метод возвращает 1 для числа 0
        assertEquals(1, Task2.countDigits(0));
    }

    @Test
    public void testCountDigitsPositiveNumbers() {
        // Проверяет, что метод корректно считает количество цифр для положительных чисел
        assertEquals(1, Task2.countDigits(5));
        assertEquals(2, Task2.countDigits(23));
        assertEquals(3, Task2.countDigits(123));
        assertEquals(4, Task2.countDigits(1234));
    }

    @Test
    public void testCountDigitsNegativeNumbers() {
        // Проверяет, что метод корректно считает количество цифр для отрицательных чисел
        assertEquals(1, Task2.countDigits(-5));
        assertEquals(2, Task2.countDigits(-23));
        assertEquals(3, Task2.countDigits(-123));
        assertEquals(4, Task2.countDigits(-1234));
    }

    @Test
    public void testCountDigitsLargeNumbers() {
        // Проверяет, что метод корректно считает количество цифр для больших чисел
        assertEquals(10, Task2.countDigits(1234567890));
        assertEquals(10, Task2.countDigits(-1234567890));
    }

    @Test
    public void testCountDigitsSingleDigitNumbers() {
        // Проверяет, что метод корректно считает количество цифр для однозначных чисел
        assertEquals(1, Task2.countDigits(1));
        assertEquals(1, Task2.countDigits(-1));
    }
}
