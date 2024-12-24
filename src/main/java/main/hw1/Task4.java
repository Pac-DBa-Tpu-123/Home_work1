package main.hw1;

public class Task4 {

    private Task4() {
    }

        public static String fixString(String str) {
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length - 1; i += 2) {
            char flag = array[i];
            array[i] = array[i + 1];
            array[i + 1] = flag;
        }
        return new String(array);
    }

}
