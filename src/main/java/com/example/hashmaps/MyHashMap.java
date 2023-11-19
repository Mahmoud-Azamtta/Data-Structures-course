package com.example.hashmaps;

import java.util.LinkedList;

public class MyHashMap {
    private static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] map;

    public MyHashMap(int capacity) {
        this.map = new LinkedList[capacity];
    }

    private int hash(int key) {
        return key % map.length;
    }

    public void put(int key, String value) {
        int index = hash(key);

        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }

        LinkedList<Entry> bucket = map[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        Entry entry = new Entry(key, value);
        bucket.addLast(entry);
    }

    public String getValueAt(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        if (bucket != null) {
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry.value;
        }
        return null;
    }

    public void removeValueAt(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        if (bucket == null)
            throw new IllegalStateException();

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry = null;
                return;
            }
        }
        throw new IllegalStateException();
    }
}
