package Progect1Test;

import main.project1.ConsoleHangman;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ConsoleHangmanTest {

    private ConsoleHangman consoleHangman;

    @Before
    public void setUp() {
        consoleHangman = new ConsoleHangman();
    }

    @Test
    public void testOption1() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        consoleHangman.startGame();

        System.setIn(sysInBackup);
        System.setOut(null);

        String output = outContent.toString();
        assertTrue(output.contains("Добро пожаловать в игру Виселица!"));
        assertTrue(output.contains("1. Начать игру"));
        assertTrue(output.contains("2. Выход"));
        assertTrue(output.contains("Ты победил!"));
        assertTrue(output.contains("Игра окончена"));
    }


    @Test
    public void testOption2() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        consoleHangman.startGame();

        System.setIn(sysInBackup);
        System.setOut(null);

        String output = outContent.toString();
        assertTrue(output.contains("Добро пожаловать в игру Виселица!"));
        assertTrue(output.contains("1. Начать игру"));
        assertTrue(output.contains("2. Выход"));
        assertTrue(output.contains("Игра окончена"));
    }

    @Test
    public void testInvalidOption() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        consoleHangman.startGame();

        System.setIn(sysInBackup);
        System.setOut(null);

        String output = outContent.toString();
        assertTrue(output.contains("Добро пожаловать в игру Виселица!"));
        assertTrue(output.contains("1. Начать игру"));
        assertTrue(output.contains("2. Выход"));
        assertTrue(output.contains("Неверный ввод. Попробуйте еще раз:"));
        assertTrue(output.contains("Игра окончена"));
    }
}

