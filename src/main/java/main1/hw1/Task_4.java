package main1.hw1;

public class Task_4 {

        public static String fixString(String str) {
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length - 1; i += 2) {
            char f = array[i];
            array[i] = array[i + 1];
            array[i + 1] = f;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(fixString("214365"));
        System.out.println(fixString("eHllo"));
        System.out.println(fixString(" Iolevs optr!"));
    }

}
