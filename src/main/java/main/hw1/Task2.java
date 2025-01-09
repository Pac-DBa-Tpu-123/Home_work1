package main.hw1;

public class Task2 {

    private static final int CONST_NUMBER = 10;



    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int absNumber = Math.abs(number);

        int count = 0;

        while (absNumber > 0) {
            absNumber /= CONST_NUMBER;
            count++;
        }

        return count;
    }

}
