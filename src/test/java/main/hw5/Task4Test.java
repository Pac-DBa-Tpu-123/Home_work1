package main.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @ParameterizedTest
    @ValueSource(strings = {
        "Password123!",
        "P@ssword",
        "P|ssword",
        "P#ssword",
        "P$ssword",
        "P%ssword",
        "P^ssword",
        "P&ssword",
        "P*ssword",
        "P~ssword"
    })
    public void testValidPasswords(String password) {
        assertTrue(Task4.isValidPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "Password123",
        "NoSpecialChar"
    })
    @NullAndEmptySource
    public void testInvalidPasswords(String password) {
        assertFalse(Task4.isValidPassword(password));
    }
}
