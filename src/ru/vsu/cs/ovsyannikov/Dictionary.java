package ru.vsu.cs.ovsyannikov;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {

    private final List<KeyValuePair<K, V>> pairs;

    public Dictionary() {
        this.pairs = new ArrayList<>();
    }

    private record KeyValuePair<K, V>(K key, V value) {

    }

    public void put(K key, V value) {
        pairs.add(new KeyValuePair<>(key, value));
    }

    public V get(K key) {
        for (KeyValuePair<K, V> pair : pairs) {
            if (key.equals(pair.key)) {
                return pair.value;
            }
        }
        return null;
    }

    public List<K> getKeys(V value) {
        List<K> keys = new ArrayList<>();

        for (KeyValuePair<K, V> pair : pairs) {
            if (value.equals(pair.value)) {
                keys.add(pair.key);
            }
        }

        return keys;
    }

    public boolean deleteByValue(V value) {
        return pairs.removeIf(pair -> value.equals(pair.value));
    }

    public boolean deleteByKey(K key) {
        return pairs.removeIf(pair -> key.equals(pair.key));
    }

}
