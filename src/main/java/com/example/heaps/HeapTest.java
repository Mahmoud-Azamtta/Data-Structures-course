package com.example.heaps;

public class HeapTest {
    public static void main(String[] args) {
        // heap sort:
        int[] arr = { 4, 1, 6, 8, 3, 2 };

        Heap heap = new Heap(8);
        heap.insert(5);
        heap.insert(9);
        heap.insert(1);
        heap.insert(17);
        heap.insert(12);
        heap.insert(3);
        heap.insert(4);
        heap.insert(11);
        heap.print();
//        System.out.println(HeapSorting.kthLargestElement(arr, 2));
//        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, i);
    }

    public static void heapify(int[] arr, int parent) {
        int largerChild = parent;

        int leftChild = 2 * parent + 1;
        if (leftChild < arr.length && arr[leftChild] > arr[largerChild])
            largerChild = leftChild;

        int rightChild = 2 * parent + 2;
        if (rightChild < arr.length && arr[rightChild] > arr[largerChild])
            largerChild = rightChild;

        if (largerChild == parent)
            return;

        swap(arr, parent, largerChild);
        heapify(arr, largerChild);
    }

    public static void swap(int[] arr, int parent, int child) {
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }
}
