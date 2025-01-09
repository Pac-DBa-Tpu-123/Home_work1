package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    // Проверяет, что метод возвращает true, когда один массив полностью вложен в другой
    public void testIsNestableTrue() {
        assertTrue(Task3.isNestable(new int[]{3, 4, 5}, new int[]{1, 2, 6, 7}));
        assertTrue(Task3.isNestable(new int[]{10, 11, 12}, new int[]{5, 6, 13, 14}));
    }

    @Test
    // Проверяет, что метод возвращает false, когда один массив не вложен в другой
    public void testIsNestableFalse() {
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertFalse(Task3.isNestable(new int[]{5, 6, 7}, new int[]{1, 2, 3}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    // Проверяет, что метод корректно работает с массивами, содержащими один элемент
    public void testIsNestableSingleElementArrays() {
        assertTrue(Task3.isNestable(new int[]{5}, new int[]{1, 10}));
        assertFalse(Task3.isNestable(new int[]{5}, new int[]{1, 4}));
    }

    @Test
    // Проверяет, что метод корректно работает с пустыми массивами
    public void testIsNestableEmptyArrays() {
        assertTrue(Task3.isNestable(new int[]{}, new int[]{1, 2, 3}));
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{}));
        assertFalse(Task3.isNestable(new int[]{}, new int[]{}));
    }

    @Test
    // Проверяет, что метод корректно работает, когда минимальные и максимальные значения одинаковы
    public void testIsNestableSameMinMax() {
        assertTrue(Task3.isNestable(new int[]{5, 5, 5}, new int[]{1, 10, 10}));
        assertFalse(Task3.isNestable(new int[]{5, 5, 5}, new int[]{5, 5, 5}));
    }
}
