package ru.vsu.cs.ovsyannikov;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        testGetKeys();
        testDeleteKeys();
        testDeleteValue();
    }

    private static void testGetKeys() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("SameValueKey1", 1);
        dictionary.put("SameValueKey2", 1);
        dictionary.put("ValueKey1", 4);
        dictionary.put("ValueKey2", 5);

        Collection<String> keys = dictionary.getKeys(1);
        System.out.println(keys.toString());
    }

    private static void testDeleteKeys() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("SameValueKey1", 1);
        dictionary.put("SameValueKey2", 1);
        dictionary.put("ValueKey1", 4);
        dictionary.put("ValueKey2", 5);

        boolean result = dictionary.deleteByValue(1);

        if (result && dictionary.get("SameValueKey1") == null && dictionary.get("SameValueKey2") == null) {
            System.out.println("Success");
        } else {
            System.out.println("The method does not work (value does not exist)");
        }

        result = dictionary.deleteByValue(9);

        if (result) {
            System.out.println("The method does not work (value does not exist)");
        } else {
            System.out.println("No success");
        }
    }

    private static void testDeleteValue() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("SameValueKey1", 1);
        dictionary.put("SameValueKey2", 1);
        dictionary.put("ValueKey1", 4);
        dictionary.put("ValueKey2", 5);

        boolean result = dictionary.deleteByKey("SameValueKey1");

        if (result && dictionary.get("SameValueKey1") == null) {
            System.out.println("Success");
        } else {
            System.out.println("The method does not work");
        }

        result = dictionary.deleteByKey("NonExistKey");

        if (result) {
            System.out.println("The method does not work (value does not exist)");
        } else {
            System.out.println("No success");
        }
    }
}
