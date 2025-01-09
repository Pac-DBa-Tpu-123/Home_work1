package main.hw1;

public final class Task1 {

    private Task1() {
    }

    private static final int NUMBER_OF_SECONDS = 60;

    public static int minutesToSeconds(String time) {
        if (time == null || !time.matches("\\d+:\\d{2}")) {
            return -1;
        }

        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        if (seconds >= NUMBER_OF_SECONDS) {
            return -1;
        }

        return minutes * NUMBER_OF_SECONDS + seconds;
    }
}
