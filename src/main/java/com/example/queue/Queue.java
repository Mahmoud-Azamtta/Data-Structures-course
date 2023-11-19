package com.example.queue;

public interface Queue {
    void add(int elm);
    int remove();
    int peek();
    boolean isEmpty();
}
