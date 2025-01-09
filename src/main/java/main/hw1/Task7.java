package main.hw1;

public class Task7 {

    private Task7() {
    }

    private static final int NUMBER_OF_BITS = 32;

    public static int rotateLeft(int n, int shift) {
        int effectiveShift = shift % NUMBER_OF_BITS;
        return (n << effectiveShift) | (n >>> (NUMBER_OF_BITS - effectiveShift));
    }

    public static int rotateRight(int n, int shift) {
        int effectiveShift = shift % NUMBER_OF_BITS;
        return (n >>> effectiveShift) | (n << (NUMBER_OF_BITS - effectiveShift));
    }
}
