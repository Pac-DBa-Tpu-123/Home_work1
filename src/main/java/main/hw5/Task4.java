package main.hw5;

import java.util.regex.Pattern;

public class Task4 {

    private Task4() {
    }

    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[~!@#$%^&*|]");

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return SPECIAL_CHARACTER_PATTERN.matcher(password).find();
    }
}
