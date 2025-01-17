package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {

    // Проверяет, что метод возвращает 1 для числа 0
    @Test
    public void testCountDigitsZero() {
        assertEquals(1, Task2.countDigits(0));
    }

    // Проверяет, что метод корректно считает количество цифр для положительных чисел
    @Test
    public void testCountDigitsPositiveNumbers() {
        assertEquals(1, Task2.countDigits(5));
        assertEquals(2, Task2.countDigits(23));
        assertEquals(3, Task2.countDigits(123));
        assertEquals(4, Task2.countDigits(1234));
    }

    // Проверяет, что метод корректно считает количество цифр для отрицательных чисел
    @Test
    public void testCountDigitsNegativeNumbers() {
        assertEquals(1, Task2.countDigits(-5));
        assertEquals(2, Task2.countDigits(-23));
        assertEquals(3, Task2.countDigits(-123));
        assertEquals(4, Task2.countDigits(-1234));
    }

    // Проверяет, что метод корректно считает количество цифр для больших чисел
    @Test
    public void testCountDigitsLargeNumbers() {
        assertEquals(10, Task2.countDigits(1234567890));
        assertEquals(10, Task2.countDigits(-1234567890));
    }

    // Проверяет, что метод корректно считает количество цифр для однозначных чисел
    @Test
    public void testCountDigitsSingleDigitNumbers() {
        assertEquals(1, Task2.countDigits(1));
        assertEquals(1, Task2.countDigits(-1));
    }
}
