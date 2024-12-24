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
        assertEquals(1, Task2.countDigits(5)); // 5 имеет 1 цифру
        assertEquals(2, Task2.countDigits(23)); // 23 имеет 2 цифры
        assertEquals(3, Task2.countDigits(123)); // 123 имеет 3 цифры
        assertEquals(4, Task2.countDigits(1234)); // 1234 имеет 4 цифры
    }

    @Test
    public void testCountDigitsNegativeNumbers() {
        // Проверяет, что метод корректно считает количество цифр для отрицательных чисел
        assertEquals(1, Task2.countDigits(-5)); // -5 имеет 1 цифру
        assertEquals(2, Task2.countDigits(-23)); // -23 имеет 2 цифры
        assertEquals(3, Task2.countDigits(-123)); // -123 имеет 3 цифры
        assertEquals(4, Task2.countDigits(-1234)); // -1234 имеет 4 цифры
    }

    @Test
    public void testCountDigitsLargeNumbers() {
        // Проверяет, что метод корректно считает количество цифр для больших чисел
        assertEquals(10, Task2.countDigits(1234567890)); // 1234567890 имеет 10 цифр
        assertEquals(10, Task2.countDigits(-1234567890)); // -1234567890 имеет 10 цифр
    }

    @Test
    public void testCountDigitsSingleDigitNumbers() {
        // Проверяет, что метод корректно считает количество цифр для однозначных чисел
        assertEquals(1, Task2.countDigits(1)); // 1 имеет 1 цифру
        assertEquals(1, Task2.countDigits(-1)); // -1 имеет 1 цифру
        assertEquals(1, Task2.countDigits(9)); // 9 имеет 1 цифру
        assertEquals(1, Task2.countDigits(-9)); // -9 имеет 1 цифру
    }
}


