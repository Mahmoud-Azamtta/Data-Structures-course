package com.example.lab;

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Integer> list = new ArrayList<>();
    int index = 0;

    public void enqueue(int elm) {
        list.add(elm);
        index++;
    }

    public int dequeue() {
        return list.remove(index);
    }

    public int peek() {
        return list.get(index);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
