package main1.hw1;

import java.util.Arrays;

public class Task_6 {

    public static int count(int n) {
        return process(n, 0);
    }

    private static int process(int n, int steps) {
        if (n == 6174) {
            return steps;
        }

        String num = String.valueOf(n);
        char[] array = num.toCharArray();
        Arrays.sort(array);

        String up = new String(array);
        String down = new StringBuilder(up).reverse().toString();

        int upNum = Integer.parseInt(up);
        int downNum = Integer.parseInt(down);

        int diff = downNum - upNum;

        return process(diff, steps + 1);
    }

    public static void main(String[] args) {
        System.out.println(count(3524));
        System.out.println(count(6621));
        System.out.println(count(6554));
        System.out.println(count(1234));
        System.out.println(count(6174));
    }

}