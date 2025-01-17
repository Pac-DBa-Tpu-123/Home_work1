package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    // Проверяет, что метод возвращает true, когда один массив полностью вложен в другой
    @Test
    public void testIsNestableTrue() {
        assertTrue(Task3.isNestable(new int[]{3, 4, 5}, new int[]{1, 2, 6, 7}));
        assertTrue(Task3.isNestable(new int[]{10, 11, 12}, new int[]{5, 6, 13, 14}));
    }

    // Проверяет, что метод возвращает false, когда один массив не вложен в другой
    @Test
    public void testIsNestableFalse() {
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertFalse(Task3.isNestable(new int[]{5, 6, 7}, new int[]{1, 2, 3}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    // Проверяет, что метод корректно работает с массивами, содержащими один элемент
    @Test
    public void testIsNestableSingleElementArrays() {
        assertTrue(Task3.isNestable(new int[]{5}, new int[]{1, 10}));
        assertFalse(Task3.isNestable(new int[]{5}, new int[]{1, 4}));
    }

    // Проверяет, что метод корректно работает с пустыми массивами
    @Test
    public void testIsNestableEmptyArrays() {
        assertTrue(Task3.isNestable(new int[]{}, new int[]{1, 2, 3}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{}));
        assertFalse(Task3.isNestable(new int[]{}, new int[]{}));
    }

    // Проверяет, что метод корректно работает, когда минимальные и максимальные значения одинаковы
    @Test
    public void testIsNestableSameMinMax() {
        assertTrue(Task3.isNestable(new int[]{5, 5, 5}, new int[]{1, 10, 10}));
        assertFalse(Task3.isNestable(new int[]{5, 5, 5}, new int[]{5, 5, 5}));
    }
}
