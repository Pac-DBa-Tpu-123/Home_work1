package main.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {

    private Task2() {
    }

    public static List<String> clusterize(String input) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder currentCluster = new StringBuilder();

        for (char c : input.toCharArray()) {
            currentCluster.append(c);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    result.add(currentCluster.toString());
                    currentCluster.setLength(0);
                }
            }
        }

        return result;
    }

}
