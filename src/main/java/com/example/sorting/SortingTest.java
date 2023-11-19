package com.example.sorting;

import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        Random random = new Random();
        Stopwatch stopwatch = new Stopwatch();
        final int len = 100_000;

        int[] arr = { 2, 6, 1, 7, 4, 8 };
//        for (int i = 0; i < len; i++) {
//            arr[i] = random.nextInt();
//        }

        Sorting.recursionBubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        //Sorting.bubbleSort(arr);
        //Sorting.selectionSort(arr);
        //Sorting.insertionSort(arr);
        //Sorting.mergeSort(arr);
        //Sorting.quickSort(arr);
        //Sorting.heapSort(arr);
        //Arrays.sort(arr);
        stopwatch.start();
        stopwatch.stop();
        System.out.println(stopwatch.getTimeElapsed() + " Milliseconds");
    }
}
