package com.example.queue;

import java.util.NoSuchElementException;


// this approach has a problem which is the placement of the rear index
// so, we can solve this problem by using the circular array principle.

public class ArrayQueue<T> {

    private final T[] arr;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        arr = (T[]) new Object[capacity];
    }

    public ArrayQueue() {
        final int INITIAL_CAPACITY = 100;
        arr = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void enqueue(T elm) {
        if (isFull())
            throw new IllegalStateException();

        if (isEmpty()) {
            arr[front] = elm;
            rear++;
        }
        else
            arr[rear++] = elm;
    }

    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        if (rear == front) {
            rear++;
            return arr[front++];
        }

        return arr[front++];
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();

        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == arr.length;
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder();
        queue.append("[");
        for (int i = front; i < rear; i++) {
            if (i == rear - 1)
                queue.append(arr[i]);
            else {
                queue.append(arr[i]);
                queue.append(", ");
            }
        }
        queue.append("]");
        return queue.toString();
    }
}
