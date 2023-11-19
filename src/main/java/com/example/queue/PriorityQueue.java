package com.example.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public PriorityQueue(int capacity) {
        arr = new int[capacity];
    }

    public PriorityQueue() {
        arr = new int[16];
    }

    public void enqueue(int elm) {
        if (isFull()) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < rear; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        int place = shiftItemsToInsert(elm);
        arr[place] = elm;
        rear++;
        size++;
    }

    private int shiftItemsToInsert(int item) {
        int place = rear - 1;
        while (place >= front) {
            if (item < arr[place]) {
                arr[place + 1] = arr[place];
            }
            else
                break;
            place--;
        }
        return place + 1;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        size--;
        return arr[front++];
    }

    // The remove method is the same as the dequeue method, but assuming that
    // the elements with the largest values has a higher priority
    // they will get removed first
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr[--size];
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

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
