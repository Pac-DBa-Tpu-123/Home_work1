package main.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class Task5Test {

    @Test
    public void testParseContactsASC() {
        List<String> contacts = Arrays.asList("Иван Иванов", "Петр Петров", "Анна Семенович", "Мария Кубышкина");
        List<Task5.Contact> sortedContacts = Task5.parseContacts(contacts, "ASC");

        List<String> expectedNames = Arrays.asList("Иван Иванов", "Мария Кубышкина", "Петр Петров", "Анна Семенович");
        List<String> actualNames = sortedContacts.stream().map(Task5.Contact::getName).toList();

        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testParseContactsDESC() {
        List<String> contacts = Arrays.asList("Иван Иванов", "Петр Петров", "Анна Семенович", "Мария Кубышкина");
        List<Task5.Contact> sortedContacts = Task5.parseContacts(contacts, "DESC");

        List<String> expectedNames = Arrays.asList("Анна Семенович", "Петр Петров", "Мария Кубышкина", "Иван Иванов");
        List<String> actualNames = sortedContacts.stream().map(Task5.Contact::getName).toList();

        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testParseContactsEmpty() {
        List<String> contacts = Arrays.asList();
        List<Task5.Contact> sortedContacts = Task5.parseContacts(contacts, "ASC");

        assertTrue(sortedContacts.isEmpty());
    }

    @Test
    public void testParseContactsNull() {
        List<Task5.Contact> sortedContacts = Task5.parseContacts(null, "ASC");

        assertTrue(sortedContacts.isEmpty());
    }

    @Test
    public void testParseContactsSingleName() {
        List<String> contacts = Arrays.asList("Анна");
        List<Task5.Contact> sortedContacts = Task5.parseContacts(contacts, "ASC");

        List<String> expectedNames = Arrays.asList("Анна");
        List<String> actualNames = sortedContacts.stream().map(Task5.Contact::getName).toList();

        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testParseContactsMoreNames() {
        List<String> contacts = Arrays.asList("Иван", "Петр", "Анна", "Мария");
        List<Task5.Contact> sortedContacts = Task5.parseContacts(contacts, "ASC");

        List<String> expectedNames = Arrays.asList( "Анна", "Иван", "Мария", "Петр");
        List<String> actualNames = sortedContacts.stream().map(Task5.Contact::getName).toList();

        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testParseContactsMoreNames2() {
        List<String> contacts = Arrays.asList("Иван", "Петр", "Анна", "Мария");
        List<Task5.Contact> sortedContacts = Task5.parseContacts(contacts, "DESC");

        List<String> expectedNames = Arrays.asList("Петр", "Мария", "Иван", "Анна");
        List<String> actualNames = sortedContacts.stream().map(Task5.Contact::getName).toList();

        assertEquals(expectedNames, actualNames);
    }

}
