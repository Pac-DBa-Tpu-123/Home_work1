package main.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {

    private Task1() {
    }

    private static final int NUMBER_OF_SECONDS = 60;

    public static Duration calculateAverageSessionTime(List<String> sessions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration totalDuration = Duration.ZERO;

        for (String session : sessions) {
            String[] parts = session.split(" - ");
            LocalDateTime start = LocalDateTime.parse(parts[0], formatter);
            LocalDateTime end = LocalDateTime.parse(parts[1], formatter);
            totalDuration = totalDuration.plus(Duration.between(start, end));
        }

        return totalDuration.dividedBy(sessions.size());
    }

    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % NUMBER_OF_SECONDS;
        return hours + "ч " + minutes + "м";
    }
}
