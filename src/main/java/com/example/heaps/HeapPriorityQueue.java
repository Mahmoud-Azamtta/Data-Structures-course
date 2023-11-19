package com.example.heaps;

public class HeapPriorityQueue {
    private Heap heap;

    public HeapPriorityQueue(int capacity) {
        this.heap = new Heap(capacity);
    }

    public void enqueue(int elm) {
        heap.insert(elm);
    }

    public int dequeue() {
        return heap.delete();
    }

    public int peek() {
        return heap.getRoot();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
