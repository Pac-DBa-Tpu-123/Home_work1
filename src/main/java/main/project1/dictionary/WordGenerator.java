package main.project1.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WordGenerator {

    private static final String FILE_PATH = "src/main/java/main/project1/dictionary/words.txt";
    private static final Logger LOGGER = LogManager.getLogger();

    public String getRandomWord() {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            LOGGER.error("Произошла ошибка IOException", e);
            return null;
        }

        if (words.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
}
