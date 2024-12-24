package main.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {



        @Test
        // Проверяет, что метод корректно преобразует строку времени в секунды для различных входных данных
        public void testMinutesToSecondsValidInput() {
            assertEquals(120, Task1.minutesToSeconds("02:00"));
            assertEquals(816, Task1.minutesToSeconds("13:36"));
            assertEquals(659, Task1.minutesToSeconds("10:59"));
            assertEquals(59940, Task1.minutesToSeconds("999:00"));
        }

        @Test
        // Проверяет, что метод возвращает -1 для строк, где секунды больше или равны 60)
        public void testMinutesToSecondsInvalidSeconds() {
            assertEquals(-1, Task1.minutesToSeconds("10:60"));
            assertEquals(-1, Task1.minutesToSeconds("13:61"));
        }

        @Test
        // Проверяет, что метод возвращает -1 для строк времени с неверным форматом
        public void testMinutesToSecondsInvalidFormat() {
            assertEquals(-1, Task1.minutesToSeconds("12:ab"));
            assertEquals(-1, Task1.minutesToSeconds("12:09:10"));
            assertEquals(-1, Task1.minutesToSeconds("ab:cd"));
        }

        @Test
        // Проверяет, что метод возвращает -1 для null входных данных
        public void testMinutesToSecondsNullInput() {
            assertEquals(-1, Task1.minutesToSeconds(null));
        }

        @Test
        // Проверяет, что метод возвращает -1 для пустых входных данных
        public void testMinutesToSecondsEmptyInput() {
            assertEquals(-1, Task1.minutesToSeconds(""));
        }

        @Test
        // Проверяет, что метод возвращает -1 для строк времени с неправильными минутами
        public void testMinutesToSecondsInvalidMinutes() {
            assertEquals(-1, Task1.minutesToSeconds("ab:00"));
            assertEquals(-1, Task1.minutesToSeconds(":00"));
        }
    }


