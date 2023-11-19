package com.example.heaps;

import java.util.Arrays;

public class Heap {
    private int[] arr;
    private int index;
    private int root;

    public Heap() {
        this.arr = new int[10];
    }

    public Heap(int capacity) {
        this.arr = new int[capacity];
    }

    public void insert(int elm) {
        if (isFull())
            throw new IllegalStateException("The heap is full");
        if (isEmpty()) {
            root = arr[index++] = elm;
            return;
        }

        arr[index++] = elm;
        bubbleUp();
        this.root = arr[0];
    }

    public int delete() {
        if (isEmpty())
            throw new IllegalStateException("can't delete from an empty heap");

        int root = arr[0];
        arr[0] = arr[index - 1];
        index--;
        bubbleDown();
        this.root = arr[0];
        return root;
    }

    private void bubbleDown() {
        int parent = 0;
        while (parent <= index && !isValidParent(parent)) {
            int largest = largerChildIndex(parent);
            swap(parent, largest);
            parent = largest;
        }
    }

    /**
     * // My approach: (?)
     * private bubbleUp(int child) {
     *     int parent = parent(child);
     *     if (parent <= 0)
     *         return;
     *     if (arr[child] < arr[parent])
     *        return;
     *     swap(child, parent);
     *
     *     bubbleUp(parent);
     * }
     */

    private void bubbleUp() {
        int child = index - 1;
        while (child > 0 && arr[child] > arr[parent(child)]) {
            swap(child, parent(child));
            child = parent(child);
        }
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == arr.length;
    }

    private int largerChildIndex(int parent) {
        if (!hasLeftChild(parent))
            return parent; // can't return the right child because it doesn't exist
                           // that's how heaps work we add to the left then the right
        if (!hasRightChild(parent))
            return leftIndex(parent); // here it's guaranteed that we have a left child
                                      // because if we didn't have one the method will return
                                      // from the first if statement
        return arr[leftIndex(parent)] > arr[rightIndex(parent)] ? leftIndex(parent) : rightIndex(parent);
    }

    private boolean hasLeftChild(int parent) {
        // if we have a left child then its index must be less than or equal
        // to the total number of items in the heap
        return leftIndex(parent) <= index;
    }

    private boolean hasRightChild(int parent) {
        return rightIndex(parent) <= index;
    }

    private boolean isValidParent(int parent) {
        if (!hasLeftChild(parent))
            return true;

        boolean isValid = arr[parent] >= arr[leftIndex(parent)];

        if (hasRightChild(parent))
            isValid &= arr[parent] >= arr[rightIndex(parent)];

        // the negation is in the while loop condition is the bubbleDown method
        // so this method return true if the parent is valid
        return isValid;
    }

    private int leftIndex(int parent) {
        return parent * 2 + 1;
    }

    private int rightIndex(int parent) {
        return parent * 2 + 2;
    }

    private void swap(int child, int parent) {
        int temp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int getRoot() {
        return this.root;
    }
}
