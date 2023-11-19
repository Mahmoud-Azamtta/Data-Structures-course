package com.example.heaps;

import java.util.Arrays;

public class MyHeap {
    private final int[] arr;
    private int index;
    private int root;

    public MyHeap(int capacity) {
        this.arr = new int[capacity];
    }

    public void insert(int elm) {
        if (index == 0) {
            arr[index++] = root = elm;
            return;
        }
        arr[index++] = elm;
        bubbleUp(index - 1);
        root = arr[0];
    }

    public int remove() {
        if (index == 0)
            throw new IllegalStateException();
        int removed = arr[index - 1];
        swap(0, index - 1);
        index--;

        bubbleDown(0);
        root = arr[0];
        return removed;
    }

    private void bubbleDown(int parent) {
        if (parent == index - 1)
            return;

        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int largest = parent;

        if (leftChild < index && arr[leftChild] > arr[largest])
            largest = leftChild;
        if (rightChild < index && arr[rightChild] > arr[largest])
            largest = rightChild;

        if (largest == parent)
            return;
        bubbleDown(largest);
    }

    private void bubbleUp(int child) {
        if (child <= 0)
            return;

        if (arr[child] > arr[parentOf(child)])
            swap(child, parentOf(child));
        else
            return;

        child = parentOf(child);
        bubbleUp(child);
    }

    private int parentOf(int child) {
        return (child - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }
}
