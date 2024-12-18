package main1.hw1;

public class Task_5{

    private static boolean palindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left +=1;
            right -=1;
        }
        return true;
    }

    private static String predok(String str) {
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i+=2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            descendant.append(sum);
        }
        return descendant.toString();
    }

    public static boolean isPalindromeDescendant(long number) {
        String str = Long.toString(number);
        while (str.length() > 1) {
            if (palindrome(str)) {
                return true;
            }
            str = predok(str);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(11211230));
        System.out.println(isPalindromeDescendant(13001120));
        System.out.println(isPalindromeDescendant(23336014));
        System.out.println(isPalindromeDescendant(11));
        System.out.println(isPalindromeDescendant(12321));
        System.out.println(isPalindromeDescendant(123456));
    }
}


