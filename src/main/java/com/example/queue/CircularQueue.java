package com.example.queue;

public class CircularQueue {

    private final int[] arr;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        arr = new int[capacity];
    }

    public void enqueue(int elm) {
        if (size == arr.length)
            throw new IllegalStateException();

        arr[rear] = elm;
        rear = (rear + 1) % arr.length;
        size++;
    }

    public int dequeue() {
        int elm = arr[front];
        arr[front] = 0;
        front = (front + 1) % arr.length;
        size--;
        return elm;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
