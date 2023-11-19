package com.example.queue;

import com.example.linkedlist.MyLinkedList;

public class LinkedQueue extends MyLinkedList implements Queue {
    @Override
    public void add(int elm) {
        addLast(elm);
    }

    @Override
    public int remove() {
        int i = first();
        removeFirst();
        return i;
    }

    @Override
    public int peek() {
        return first();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
