package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {

    @Test
    // Проверяет, что метод rotateLeft корректно выполняет циклический сдвиг влево
    public void testRotateLeft() {
        assertEquals(Integer.toBinaryString(2), Integer.toBinaryString(Task7.rotateLeft(1, 1)));
        assertEquals(Integer.toBinaryString(4), Integer.toBinaryString(Task7.rotateLeft(1, 2)));
        assertEquals(Integer.toBinaryString(8), Integer.toBinaryString(Task7.rotateLeft(1, 3)));
        assertEquals(Integer.toBinaryString(16), Integer.toBinaryString(Task7.rotateLeft(1, 4)));
    }

    @Test
    // Проверяет, что метод rotateLeft корректно выполняет циклический сдвиг влево для больших значений сдвига
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
