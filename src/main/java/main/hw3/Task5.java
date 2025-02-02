package main.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task5 {

    private Task5() {
    }

    public static List<Contact> parseContacts(List<String> contacts, String order) {
        if (contacts == null) {
            return new ArrayList<>();
        }

        List<String> mutableContacts = new ArrayList<>(contacts);

        Comparator<String> comparator = (a, b) -> {
            String lastNameA = getLastName(a);
            String lastNameB = getLastName(b);
            return lastNameA.compareTo(lastNameB);
        };

        if (order.equalsIgnoreCase("DESC")) {
            mutableContacts.sort(comparator.reversed());
        } else {
            mutableContacts.sort(comparator);
        }

        List<Contact> result = new ArrayList<>();
        for (String name : mutableContacts) {
            result.add(new Contact(name));
        }

        return result;
    }

    private static String getLastName(String fullName) {
        String[] parts = fullName.split(" ");
        return parts.length > 1 ? parts[parts.length - 1] : parts[0];
    }

    public static class Contact {
        private final String name;

        public Contact(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
