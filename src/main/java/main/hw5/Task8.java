package main.hw5;

import java.util.regex.Pattern;

public class Task8 {

    private Task8() {
    }

    private static final Pattern ODD_LENGTH = Pattern.compile("^(0|1)((0|1){2})*$");
    private static final Pattern SPECIAL_START_ODD_LENGTH = Pattern.compile("^(0((0|1){2})*|1((0|1){2})*(0|1))$");
    private static final Pattern ZERO_MULTIPLE_OF_THREE = Pattern.compile("^(1*01*01*01*)*$");
    private static final Pattern NOT_11_OR_111 = Pattern.compile("^(?!11$|111$)[01]*$");
    private static final Pattern ODD_POSITIONS_ONE = Pattern.compile("^(1(0|1))*1?$");
    private static final Pattern TWO_ZEROS_ONE_ONE = Pattern.compile("^(?=.*0.*0)(?!.*1.*1)[01]*$");
    private static final Pattern NO_CONSECUTIVE_ONES = Pattern.compile("^0*(10+)*1?$|^1?(0+1)*0*$");

    public static boolean hasOddLength(String input) {
        return ODD_LENGTH.matcher(input).matches();
    }

    public static boolean startsWithZeroOddLengthOrStartsWithOneEvenLength(String input) {
        return SPECIAL_START_ODD_LENGTH.matcher(input).matches();
    }

    public static boolean hasZeroMultipleOfThree(String input) {
        return ZERO_MULTIPLE_OF_THREE.matcher(input).matches();
    }

    public static boolean isNot11Or111(String input) {
        return NOT_11_OR_111.matcher(input).matches();
    }

    public static boolean hasOddPositionsOne(String input) {
        return ODD_POSITIONS_ONE.matcher(input).matches();
    }

    public static boolean hasTwoZerosAndAtMostOneOne(String input) {
        return TWO_ZEROS_ONE_ONE.matcher(input).matches();
    }

    public static boolean hasNoConsecutiveOnes(String input) {
        return NO_CONSECUTIVE_ONES.matcher(input).matches();
    }
}
