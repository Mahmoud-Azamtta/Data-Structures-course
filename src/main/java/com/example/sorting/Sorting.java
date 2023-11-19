package com.example.sorting;

import java.util.Arrays;

public class Sorting {
    private static int comparisons;

    public static void recursionBubbleSort(int[] arr) {
        outerLoop(arr, 0);
    }

    private static void outerLoop(int[] arr, int i) {
        if (i == arr.length - 1)
            return;

        innerLoop(arr, 0);
        outerLoop(arr, i + 1);
    }

    private static void innerLoop(int[] arr, int j) {
        if (j == arr.length - 1)
            return;

        if (arr[j] > arr[j + 1])
            swap(arr, j, j + 1);
        innerLoop(arr, j + 1);
    }

    public static void bubbleSort(int[] arr) {
        boolean isSorted = true;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
        /*
         * in the second for loop we subtract (i) from (arr.length - 1)
         * because the largest element in the second pass in its place.
         * So, we don't have to do comparisons on it in the upcoming passes,
         * the same thing apply for each pass.
         */
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i)
                swap(arr, i, min);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return;

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (k < arr.length) {
            if (j == right.length || (i < left.length && left[i] < right[j]))
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int pi = partition(arr, start, end);

        quickSort(arr, start, pi - 1);
        quickSort(arr, pi + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int b = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot)
                swap(arr, ++b, i);
        }
        swap(arr, ++b, end);
        return b;
    }

    public static void heapSort(int[] arr) {
        HeapSort.sort(arr);
    }

    private static class HeapSort {
        private static int[] arr;
        private static int len;
        private static final int ROOT = 0;

        public static void sort(int[] array) {
            arr = array;
            len = arr.length;
            buildHeap();

            for (int i = arr.length - 1; i > 0; i--) {
                swap(i, ROOT);
                len--;
                heapify(ROOT);
            }
        }

        private static void buildHeap() {
            for (int i = len / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        private static void heapify(int parent) {
            if (parent >= len)
                return;
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            int maxChild = parent;

            if (left < len && arr[left] > arr[maxChild])
                maxChild = left;
            if (right < len && arr[right] > arr[maxChild])
                maxChild = right;
            if (maxChild == parent)
                return;

            swap(parent, maxChild);
            heapify(maxChild);
        }

        private static void swap(int first, int second) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
