package main.hw1;

public class Task5 {

    private Task5() {
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    private static String ancestor(String str) {
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            descendant.append(sum);
        }
        return descendant.toString();
    }

    public static boolean isPalindromeDescendant(long number) {
        String str = Long.toString(number);
        while (str.length() > 1) {
            if (isPalindrome(str)) {
                return true;
            }
            str = ancestor(str);
        }
        return true; // Возвращаем true для однозначных чисел
    }
}


