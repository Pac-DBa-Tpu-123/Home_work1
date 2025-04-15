package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    public void testHasThirdSymbolZero() {
        assertTrue(Task7.hasThirdSymbolZero("110"));
        assertTrue(Task7.hasThirdSymbolZero("000"));
        assertTrue(Task7.hasThirdSymbolZero("1000"));
        assertFalse(Task7.hasThirdSymbolZero("111"));
        assertFalse(Task7.hasThirdSymbolZero("01"));
        assertFalse(Task7.hasThirdSymbolZero(""));
    }

    @Test
    public void testStartsAndEndsWithSameSymbol() {
        assertFalse(Task7.startsAndEndsWithSameSymbol("0"));
        assertFalse(Task7.startsAndEndsWithSameSymbol("1"));
        assertTrue(Task7.startsAndEndsWithSameSymbol("00"));
        assertTrue(Task7.startsAndEndsWithSameSymbol("11"));
        assertTrue(Task7.startsAndEndsWithSameSymbol("010"));
        assertTrue(Task7.startsAndEndsWithSameSymbol("101"));
        assertFalse(Task7.startsAndEndsWithSameSymbol("01"));
        assertFalse(Task7.startsAndEndsWithSameSymbol("10"));
        assertFalse(Task7.startsAndEndsWithSameSymbol(""));
    }

    @Test
    public void testHasLengthBetween1And3() {
        assertTrue(Task7.hasLengthBetween1And3("0"));
        assertTrue(Task7.hasLengthBetween1And3("1"));
        assertTrue(Task7.hasLengthBetween1And3("00"));
        assertTrue(Task7.hasLengthBetween1And3("11"));
        assertTrue(Task7.hasLengthBetween1And3("010"));
        assertTrue(Task7.hasLengthBetween1And3("101"));
        assertFalse(Task7.hasLengthBetween1And3(""));
        assertFalse(Task7.hasLengthBetween1And3("0101"));
    }
}
