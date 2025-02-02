package main.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class Task2Test {

    @Test
    public void testClusterizeWithOnePairOfBrackets() {
        List<String> expected = Arrays.asList("()");
        List<String> actual = Task2.clusterize("()");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithSimpleBrackets() {
        List<String> expected = Arrays.asList("()", "()", "()");
        List<String> actual = Task2.clusterize("()()()");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithMultipleBrackets() {
        List<String> expected = Arrays.asList("((()))");
        List<String> actual = Task2.clusterize("((()))");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithMixedBrackets() {
        List<String> expected = Arrays.asList("((()))", "(())", "()", "()", "(()())");
        List<String> actual = Task2.clusterize("((()))(())()()(()())");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithComplexBrackets() {
        List<String> expected = Arrays.asList("((())())", "(()(()()))");
        List<String> actual = Task2.clusterize("((())())(()(()()))");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithUnbalancedBrackets() {
        List<String> expected = Arrays.asList();
        List<String> actual = Task2.clusterize("(()");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithOnlyOpeningBrackets() {
        List<String> expected = Arrays.asList();
        List<String> actual = Task2.clusterize("(((");
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeWithEmptyString() {
        List<String> expected = Arrays.asList();
        List<String> actual = Task2.clusterize("");
        assertEquals(expected, actual);
    }
}
