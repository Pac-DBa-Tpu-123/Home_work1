package main.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {

    @Test
    public void testConvertToRomanWithSimpleNumbers() {
        assertEquals("II", Task4.convertToRoman(2));
        assertEquals("XII", Task4.convertToRoman(12));
        assertEquals("XVI", Task4.convertToRoman(16));
    }

    @Test
    public void testConvertToRomanWithComplexNumbers() {
        assertEquals("MCMXCIV", Task4.convertToRoman(1994));
        assertEquals("MMMCMXCIX", Task4.convertToRoman(3999));
    }

    @Test
    public void testConvertToRomanWithEdgeNumbers() {
        assertEquals("I", Task4.convertToRoman(1));
        assertEquals("M", Task4.convertToRoman(1000));
    }

    @Test
    public void testConvertToRomanWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(4000));
    }
}
