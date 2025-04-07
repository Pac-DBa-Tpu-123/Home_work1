package main.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        if (string == null || string.isEmpty()) {
            return Optional.empty();
        }

        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("M/d/yy")
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                return Optional.of(LocalDate.parse(string, formatter));
            } catch (DateTimeParseException ignored) {
            }
        }

        Optional<LocalDate> result = Optional.empty();

        switch (string.toLowerCase()) {
            case "today":
                result = Optional.of(LocalDate.now());
                break;
            case "tomorrow":
                result = Optional.of(LocalDate.now().plusDays(1));
                break;
            case "yesterday":
                result = Optional.of(LocalDate.now().minusDays(1));
                break;
            default:
                Pattern daysAgoPattern = Pattern.compile("(\\d+) days? ago");
                Matcher matcher = daysAgoPattern.matcher(string.toLowerCase());
                if (matcher.matches()) {
                    int daysAgo = Integer.parseInt(matcher.group(1));
                    result = Optional.of(LocalDate.now().minusDays(daysAgo));
                }
                break;
        }

        return result;
    }
}
