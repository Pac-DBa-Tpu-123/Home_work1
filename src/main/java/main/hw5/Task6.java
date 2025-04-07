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

        StringBuilder regex = new StringBuilder();
        for (char c : firstString.toCharArray()) {
            regex.append(Pattern.quote(String.valueOf(c))).append(".*");
        }

        regex.setLength(regex.length() - 2);

        Pattern pattern = Pattern.compile(regex.toString());

        return pattern.matcher(secondString).find();
    }
}
