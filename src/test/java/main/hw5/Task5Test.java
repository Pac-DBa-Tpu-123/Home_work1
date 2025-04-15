package main.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    public void testValidLicensePlates() {
        assertTrue(Task5.isValidLicensePlate("А123ВЕ777"));
        assertTrue(Task5.isValidLicensePlate("О777ОО177"));
        assertTrue(Task5.isValidLicensePlate("А123ВЕ77"));
    }

    @Test
    public void testInvalidLicensePlates() {
        assertFalse(Task5.isValidLicensePlate("123АВЕ777"));
        assertFalse(Task5.isValidLicensePlate("А123ВГE77"));
        assertFalse(Task5.isValidLicensePlate("А123ВЕ7777"));
        assertFalse(Task5.isValidLicensePlate(""));
        assertFalse(Task5.isValidLicensePlate(null));
    }
}
