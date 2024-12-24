package main.hw1;

public final class Task1 {

    private static final int CONST_NUMBER = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        if (time == null || !time.matches("\\d+:\\d{2}")) {
            return -1;
        }

        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        if (seconds >= CONST_NUMBER) {
            return -1;
        }

        return minutes * CONST_NUMBER + seconds;
    }
}
