package main.hw5;

import java.util.regex.Pattern;

public class Task7 {

    private Task7() {
    }

    private static final Pattern THIRD_SYMBOL_ZERO = Pattern.compile("^[01]{2}0");
    private static final Pattern START_END_SAME = Pattern.compile("^(0.*0|1.*1)$");
    private static final Pattern LENGTH_1_TO_3 = Pattern.compile("^[01]{1,3}$");

    public static boolean hasThirdSymbolZero(String input) {
        return THIRD_SYMBOL_ZERO.matcher(input).find();
    }

    public static boolean startsAndEndsWithSameSymbol(String input) {
        return START_END_SAME.matcher(input).matches();
    }

    public static boolean hasLengthBetween1And3(String input) {
        return LENGTH_1_TO_3.matcher(input).matches();
    }
}
