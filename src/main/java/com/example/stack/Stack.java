package com.example.stack;

public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
