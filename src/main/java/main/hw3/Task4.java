package main.hw3;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Task4 {

    private Task4() {
    }

    private static final int MAXIMUM_LIMIT = 3999;
    private static final int ARABIC_NUMBER_1 = 1000;
    private static final int ARABIC_NUMBER_2 = 900;
    private static final int ARABIC_NUMBER_3 = 500;
    private static final int ARABIC_NUMBER_4 = 400;
    private static final int ARABIC_NUMBER_5 = 100;
    private static final int ARABIC_NUMBER_6 = 90;
    private static final int ARABIC_NUMBER_7 = 50;
    private static final int ARABIC_NUMBER_8 = 40;
    private static final int ARABIC_NUMBER_9 = 10;
    private static final int ARABIC_NUMBER_10 = 9;
    private static final int ARABIC_NUMBER_11 = 5;
    private static final int ARABIC_NUMBER_12 = 4;
    private static final int ARABIC_NUMBER_13 = 1;

    public static String convertToRoman(int num) {
        if (num <= 0 || num > MAXIMUM_LIMIT) {
            throw new IllegalArgumentException("Number out of range (1-3999)");
        }

        NavigableMap<Integer, String> romanNumerals = new TreeMap<>();
        romanNumerals.put(ARABIC_NUMBER_1, "M");
        romanNumerals.put(ARABIC_NUMBER_2, "CM");
        romanNumerals.put(ARABIC_NUMBER_3, "D");
        romanNumerals.put(ARABIC_NUMBER_4, "CD");
        romanNumerals.put(ARABIC_NUMBER_5, "C");
        romanNumerals.put(ARABIC_NUMBER_6, "XC");
        romanNumerals.put(ARABIC_NUMBER_7, "L");
        romanNumerals.put(ARABIC_NUMBER_8, "XL");
        romanNumerals.put(ARABIC_NUMBER_9, "X");
        romanNumerals.put(ARABIC_NUMBER_10, "IX");
        romanNumerals.put(ARABIC_NUMBER_11, "V");
        romanNumerals.put(ARABIC_NUMBER_12, "IV");
        romanNumerals.put(ARABIC_NUMBER_13, "I");

        StringBuilder roman = new StringBuilder();

        int localNum = num;
        for (Map.Entry<Integer, String> entry : romanNumerals.descendingMap().entrySet()) {
            while (localNum >= entry.getKey()) {
                roman.append(entry.getValue());
                localNum -= entry.getKey();
            }
        }

        return roman.toString();
    }
}
