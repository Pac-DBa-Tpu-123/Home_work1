package main.project1;

import java.util.Scanner;
import main.project1.hangmanGame.HangmanGameImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleHangman.class);

    public void startGame() {
        boolean hasGameStarted = true;
        LOGGER.info("Добро пожаловать в игру Виселица!");

        try (Scanner input = new Scanner(System.in)) {
            while (hasGameStarted) {
                LOGGER.info("""
                    Меню игры
                    ====================
                    1. Начать игру
                    2. Выход
                    ====================
                    """);

                switch (input.nextLine().charAt(0)) {
                    case ('1') -> {
                        HangmanGameImpl game = new HangmanGameImpl();
                        game.playGame();
                    }
                    case ('2') -> {
                        LOGGER.info("Игра окончена");
                        hasGameStarted = false;
                    }
                    default -> LOGGER.info("Неверный ввод. Попробуйте еще раз: ");
                }
            }
        }
    }

}
