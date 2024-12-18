package main1.hw1;

import java.util.Arrays;

public class Task_3 {

    public static boolean isNestable(int[] a1, int[] a2) {
        int minA1 = Arrays.stream(a1).min().getAsInt();
        int maxA1 = Arrays.stream(a1).max().getAsInt();
        int minA2 = Arrays.stream(a2).min().getAsInt();
        int maxA2 = Arrays.stream(a2).max().getAsInt();

        return minA1 > minA2 && maxA1 < maxA2;
    }

    public static void main(String[] args) {
        System.out.println(isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
        System.out.println(isNestable(new int[]{3, 1}, new int[]{4, 0}));
        System.out.println(isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));
        System.out.println(isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));
    }
}
