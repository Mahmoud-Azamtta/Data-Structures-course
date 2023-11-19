package com.example.heaps;

public class HeapSorting {
    private static int[] arr;
    private static  int length;
    private static final int ROOT = 0;

    public static void heapSort(int[] a) {
        arr = a;
        length = a.length;
        buildHeap();

        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(ROOT, i);
            length--;
            validateHeap(ROOT);
        }
    }

    public static int kthLargestElement(int[] array, int k) {
        arr = array;
        length = array.length;
        buildHeap();

        for (int i = arr.length - 1; i > arr.length - k; i--) {
            swap(ROOT, i);
            length--;
            validateHeap(ROOT);
        }
        return arr[ROOT];
    }

    private static void buildHeap() {
        for (int i = length / 2; i >= 0; i--)
            validateHeap(i);
    }

    private static void validateHeap(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int max = index;
        if (left < length && arr[left] > arr[max])
            max = left;
        if (right < length && arr[right] > arr[max])
            max = right;

        if (max == index)
            return;

        swap(max, index);
        validateHeap(max);
    }

    private static void swap(int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
