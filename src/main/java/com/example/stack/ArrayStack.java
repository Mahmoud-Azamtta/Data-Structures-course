package com.example.stack;

public class ArrayStack<E> implements Stack<E> {
    private final int CAPACITY = 1000;
    private E[] data;
    private int count;

    public ArrayStack() {
        this.data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) {
        if (size() == data.length)
            throw new StackOverflowError();

        data[count++] = e;
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        return data[--count];
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return data[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
