package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {

    // Проверяет, что метод rotateLeft корректно выполняет циклический сдвиг влево
    @Test
    public void testRotateLeft() {
        assertEquals(Integer.toBinaryString(2), Integer.toBinaryString(Task7.rotateLeft(1, 1)));
        assertEquals(Integer.toBinaryString(4), Integer.toBinaryString(Task7.rotateLeft(1, 2)));
        assertEquals(Integer.toBinaryString(8), Integer.toBinaryString(Task7.rotateLeft(1, 3)));
        assertEquals(Integer.toBinaryString(16), Integer.toBinaryString(Task7.rotateLeft(1, 4)));
    }

    // Проверяет, что метод rotateLeft корректно выполняет циклический сдвиг влево для больших значений сдвига
    @Test
    public void testRotateLeftLargeShift() {
        assertEquals(
            Integer.toBinaryString(2),
            Integer.toBinaryString(Task7.rotateLeft(1, 33))
        );
        assertEquals(
            Integer.toBinaryString(4),
            Integer.toBinaryString(Task7.rotateLeft(1, 34))
        );
    }

}
