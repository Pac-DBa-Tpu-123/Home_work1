package main.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class Task7 {

    private static final Comparator<String> NULL_ERIENDLY_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }
    };

    private final TreeMap<String, String> tree = new TreeMap<>(NULL_ERIENDLY_COMPARATOR);

    public void put(String key, String value) {
        tree.put(key, value);
    }

    public boolean containsKey(String key) {
        return tree.containsKey(key);
    }

    public String get(String key) {
        return tree.get(key);
    }
}
