package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {

    @Test
    // Проверяет, что метод возвращает 0 для числа 6174
    public void testCountKaprekarNumber() {
        assertEquals(0, Task6.count(6174));
    }

    @Test
    // Проверяет, что метод корректно обрабатывает четырехзначные числа
    public void testCountFourDigitNumbers() {
        assertEquals(3, Task6.count(1234));
        assertEquals(3, Task6.count(9876));
    }

    @Test
    // Проверяет, что метод возвращает -1 для чисел, которые не являются четырехзначными
    public void testCountInvalidLength() {
        assertEquals(-1, Task6.count(123));
        assertEquals(-1, Task6.count(12345));
        assertEquals(-1, Task6.count(1));
    }

    @Test
    // Проверяет, что метод возвращает -1 для числа 0, так как оно не является четырехзначным
    public void testCountZero() {
        assertEquals(-1, Task6.count(0));
    }

    @Test
    // Проверяет, что метод возвращает -1 для отрицательных чисел, так как они не являются четырехзначными
    public void testCountNegativeNumbers() {
        assertEquals(-1, Task6.count(-1234)); //
        assertEquals(-1, Task6.count(-9876)); //
    }

    @Test
    // Проверяет, что метод возвращает -1 для многозначных чисел
    public void testCountLargeNumbers() {
        assertEquals(-1, Task6.count(123456789));
    }
}
