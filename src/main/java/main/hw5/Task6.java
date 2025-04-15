package main.hw5;

import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean isSubsequence(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return false;
        }

        if (firstString.isEmpty()) {
            return true;
        }

        String regex = ".*" + Pattern.quote(firstString) + ".*";

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(secondString).matches();
    }
}
