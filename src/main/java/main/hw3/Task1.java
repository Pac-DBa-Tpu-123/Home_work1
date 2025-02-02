package main.hw3;

public class Task1 {

    private Task1() {
    }

    public static String atbash(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char) ('Z' - (c - 'A')));
            } else if (c >= 'a' && c <= 'z') {
                result.append((char) ('z' - (c - 'a')));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
