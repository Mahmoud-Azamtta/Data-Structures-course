package com.example.hashmaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    private final ArrayList<LinkedList<Integer>> list;
    private final int CAPACITY = 10007;

    public MyHashSet() {
        list = new ArrayList<>(10007);
        init();
    }

    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> temp = list.get(index);
        if (temp.contains(key))
            return;
        temp.add(key);
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> temp = list.get(index);
        int listIndex = temp.indexOf(key);
        if (listIndex >= 0)
            temp.remove(listIndex);
    }

    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> temp = list.get(index);
        return temp.contains(key);
    }

    private int hash(Integer key) {
        return Math.abs(key.hashCode()) % CAPACITY;
    }

    private void init() {
        for (int i = 0; i < CAPACITY; i++)
            list.add(new LinkedList<>());
    }

    public void print() {
        for (List<Integer> list : list) {
            if (list.size() > 0)
                System.out.println(list.toString());
        }
    }
}
