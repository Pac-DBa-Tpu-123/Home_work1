package main.project1.hangmanGame;

import java.util.Scanner;
import main.project1.dictionary.WordGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static main.project1.hangmanGame.HangmanPics.HANGMAN_PICS;

public class HangmanGameImpl {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MAX_ATTEMPTS = 6;
    public WordGenerator wordGenerator;
    private int mistakes;
    private static final String OUT_OF = " из ";

    public HangmanGameImpl() {
        this.wordGenerator = new WordGenerator();
        this.mistakes = 0;
    }

    public void playGame() {
        String wordToGuess = wordGenerator.getRandomWord();
        if (wordToGuess == null) {
            LOGGER.info("Не удалось найти случайное слово.");
            return;
        }

        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (mistakes < MAX_ATTEMPTS && !isWordGuessed(guessedWord) && !gameOver) {
            printGameState(guessedWord);
            LOGGER.info("Угадай букву: ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                LOGGER.info("Пожалуйста, введите один символ.");
                continue;
            }

            char guess = input.charAt(0);
            if (Character.isDigit(guess) && guess == '2') {
                LOGGER.info("Игра завершена по вашему запросу.");
                gameOver = true;
                continue;
            }

            if (Character.isWhitespace(guess)) {
                LOGGER.info("Упс! Вы нажали на пробел, введите букву.");
                continue;
            }

            if (!Character.isLetter(guess)) {
                LOGGER.info("Пожалуйста, введите букву.");
                continue;
            }

            if (!isRussianLetter(guess)) {
                LOGGER.info("Введите пожалуйста русскую букву.");
                continue;
            }

            if (makeGuess(wordToGuess, guessedWord, guess)) {
                LOGGER.info("Есть попадание!");
            } else {
                LOGGER.info("Промах! Ошибка " + (mistakes + 1) + OUT_OF + MAX_ATTEMPTS + ".");
                mistakes++;
            }
        }

        printGameState(guessedWord);
        if (isWordGuessed(guessedWord)) {
            LOGGER.info("Ты победил!");
        } else {
            LOGGER.info("Ты проиграл! Это было слово: " + wordToGuess);
        }
    }


    public boolean makeGuess(String wordToGuess, char[] guessedWord, char guess) {
        boolean hit = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
                hit = true;
            }
        }
        return hit;
    }

    private void printGameState(char[] guessedWord) {
        LOGGER.info(HANGMAN_PICS[mistakes]);
        LOGGER.info("Угадай слово: " + new String(guessedWord));
        LOGGER.info("Ошибки: " + mistakes + OUT_OF + MAX_ATTEMPTS);
    }

    public boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private boolean isRussianLetter(char c) {
        return Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC;
    }
}
