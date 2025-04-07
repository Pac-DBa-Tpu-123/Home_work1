package main.hw5;

import java.util.regex.Pattern;

public class Task5 {

    private Task5() {
    }

    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("^[А-Я]{1}\\d{3}[А-Я]{2}\\d{2,3}$");

    public static boolean isValidLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty()) {
            return false;
        }
        return LICENSE_PLATE_PATTERN.matcher(licensePlate).matches();
    }
}
