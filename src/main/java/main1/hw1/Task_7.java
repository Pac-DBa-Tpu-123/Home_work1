package main1.hw1;

public class Task_7 {
    public static int rotateLeft(int n, int shift) {
        shift = shift % 32;
        return (n << shift) | (n >>> (32 - shift));
    }

    public static int rotateRight(int n, int shift) {
        shift = shift % 32;
        return (n >>> shift) | (n << (32 - shift));
    }

    public static void main(String[] args) {
        System.out.println(rotateRight(8, 1));
        System.out.println(rotateLeft(16, 1));
        System.out.println(rotateLeft(17, 2));
    }
}


