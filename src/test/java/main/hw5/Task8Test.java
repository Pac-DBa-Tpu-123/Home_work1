package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task8Test {

    @Test
    public void testHasOddLength() {
        assertTrue(Task8.hasOddLength("1"));
        assertTrue(Task8.hasOddLength("010"));
        assertFalse(Task8.hasOddLength("01"));
        assertFalse(Task8.hasOddLength("1100"));
    }

    @Test
    public void testStartsWithZeroOddLengthOrStartsWithOneEvenLength() {
        assertTrue(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("010"));
        assertTrue(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("1010"));
        assertFalse(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("101"));
        assertFalse(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("0101"));
    }

    @Test
    public void testHasZeroMultipleOfThree() {
        assertTrue(Task8.hasZeroMultipleOfThree("000"));
        assertTrue(Task8.hasZeroMultipleOfThree("101010"));
        assertFalse(Task8.hasZeroMultipleOfThree("00"));
        assertFalse(Task8.hasZeroMultipleOfThree("1010"));
    }

    @Test
    public void testIsNot11Or111() {
        assertTrue(Task8.isNot11Or111("0"));
        assertTrue(Task8.isNot11Or111("10"));
        assertFalse(Task8.isNot11Or111("11"));
        assertFalse(Task8.isNot11Or111("111"));
    }

    @Test
    public void testHasOddPositionsOne() {
        assertTrue(Task8.hasOddPositionsOne("1"));
        assertTrue(Task8.hasOddPositionsOne("101"));
        assertFalse(Task8.hasOddPositionsOne("010"));
        assertFalse(Task8.hasOddPositionsOne("1101"));
    }

    @Test
    public void testHasTwoZerosAndAtMostOneOne() {
        assertTrue(Task8.hasTwoZerosAndAtMostOneOne("00"));
        assertTrue(Task8.hasTwoZerosAndAtMostOneOne("001"));
        assertFalse(Task8.hasTwoZerosAndAtMostOneOne("01"));
        assertFalse(Task8.hasTwoZerosAndAtMostOneOne("0011"));
    }

    @Test
    public void testHasNoConsecutiveOnes() {
        assertTrue(Task8.hasNoConsecutiveOnes("0"));
        assertTrue(Task8.hasNoConsecutiveOnes("101"));
        assertFalse(Task8.hasNoConsecutiveOnes("11"));
        assertFalse(Task8.hasNoConsecutiveOnes("1101"));
    }
}
