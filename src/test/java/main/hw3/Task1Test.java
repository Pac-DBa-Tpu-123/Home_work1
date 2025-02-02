package main.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    public void testAtbashWithCapitalLetter() {
        String input = "A";
        String expected = "Z";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithLowercaseLetter() {
        String input = "a";
        String expected = "z";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithDifferentRegisters() {
        String input = "Hello world!";
        String expected = "Svool dliow!";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithLongSentence() {
        String input = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expected = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithAllCapitalLetters() {
        String input = "HELLO";
        String expected = "SVOOL";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithAllLowercaseLetter() {
        String input = "hello";
        String expected = "svool";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithNumbersAndSpecialSymbols() {
        String input = "123!@#";
        String expected = "123!@#";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashWithEmptyString() {
        String input = "";
        String expected = "";
        String actual = Task1.atbash(input);
        assertEquals(expected, actual);
    }
}
