package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    public void testValidPasswords() {
        assertTrue(Task4.isValidPassword("Password123!"));
        assertTrue(Task4.isValidPassword("P@ssword"));
        assertTrue(Task4.isValidPassword("P|ssword"));
        assertTrue(Task4.isValidPassword("P#ssword"));
        assertTrue(Task4.isValidPassword("P$ssword"));
        assertTrue(Task4.isValidPassword("P%ssword"));
        assertTrue(Task4.isValidPassword("P^ssword"));
        assertTrue(Task4.isValidPassword("P&ssword"));
        assertTrue(Task4.isValidPassword("P*ssword"));
        assertTrue(Task4.isValidPassword("P~ssword"));
    }

    @Test
    public void testInvalidPasswords() {
        assertFalse(Task4.isValidPassword("Password123"));
        assertFalse(Task4.isValidPassword("NoSpecialChar"));
        assertFalse(Task4.isValidPassword(""));
        assertFalse(Task4.isValidPassword(null));
    }
}
