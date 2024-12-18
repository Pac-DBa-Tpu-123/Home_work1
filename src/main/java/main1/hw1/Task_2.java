package main1.hw1;

public class Task_2 {


    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        number = Math.abs(number);

        int count = 0;

        while (number > 0) {
            number /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("В числе 1234 присутствует "+countDigits(1234)+" разряда");
        System.out.println("В числе 123 присутствует "+countDigits(123)+" разряда");
        System.out.println("В числе 0 присутствует "+countDigits(0)+" разряд");
        System.out.println("В числе -123 присутствует "+countDigits(-123)+" разряда");
        System.out.println("В числе 1000 присутствует "+countDigits(1000)+" разряда");
    }
}