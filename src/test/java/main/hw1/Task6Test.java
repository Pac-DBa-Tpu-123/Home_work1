package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {

    @Test
    public void testCountKaprekarNumber() {
        // Проверяет, что метод возвращает 0 для числа 6174
        assertEquals(0, Task6.count(6174));
    }

    @Test
    public void testCountFourDigitNumbers() {
        // Проверяет, что метод корректно обрабатывает четырехзначные числа
        assertEquals(3, Task6.count(1234));
        assertEquals(3, Task6.count(9876));
    }

    @Test
    public void testCountInvalidLength() {
        // Проверяет, что метод возвращает -1 для чисел, которые не являются четырехзначными
        assertEquals(-1, Task6.count(123));
        assertEquals(-1, Task6.count(12345));
        assertEquals(-1, Task6.count(1));
    }

    @Test
    public void testCountZero() {
        // Проверяет, что метод возвращает -1 для числа 0, так как оно не является четырехзначным
        assertEquals(-1, Task6.count(0));
    }

    @Test
    public void testCountNegativeNumbers() {
        // Проверяет, что метод возвращает -1 для отрицательных чисел, так как они не являются четырехзначными
        assertEquals(-1, Task6.count(-1234)); //
        assertEquals(-1, Task6.count(-9876)); //
    }

    @Test
    public void testCountLargeNumbers() {
        // Проверяет, что метод возвращает -1 для многозначных чисел
        assertEquals(-1, Task6.count(123456789));
    }
}
