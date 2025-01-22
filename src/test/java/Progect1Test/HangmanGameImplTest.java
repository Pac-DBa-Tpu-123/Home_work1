package Progect1Test;

import main.project1.hangmanGame.HangmanGameImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HangmanGameImplTest {

    private HangmanGameImpl hangmanGame;

    @Before
    public void setUp() {
        hangmanGame = new HangmanGameImpl();
    }

    @Test
    public void testMakeGuessHit() {
        char[] guessedWord = new char[] {'_', '_', '_', '_', '_', '_'};
        boolean result = hangmanGame.makeGuess("привет", guessedWord, 'п');
        assertTrue(result);
        assertEquals('п', guessedWord[0]);
    }

    @Test
    public void testMakeGuessMiss() {
        char[] guessedWord = new char[] {'_', '_', '_', '_', '_', '_'};
        boolean result = hangmanGame.makeGuess("привет", guessedWord, 'х');
        assertEquals(false, result);
    }

    @Test
    public void testIsWordGuessedTrue() {
        char[] guessedWord = new char[] {'п', 'р', 'и', 'в', 'е', 'т'};
        boolean result = hangmanGame.isWordGuessed(guessedWord);
        assertTrue(result);
    }

    @Test
    public void testIsWordGuessedFalse() {
        char[] guessedWord = new char[] {'п', '_', 'и', '_', 'е', '_'};
        boolean result = hangmanGame.isWordGuessed(guessedWord);
        assertEquals(false, result);
    }
}
