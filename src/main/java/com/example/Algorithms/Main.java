package com.example.Algorithms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = countingSort(new int[] { 2, 4, 1, 6, 3, 2, 4, 2 });
        System.out.println(Arrays.toString(a));
    }

    private static int[] countingSort(int[] arr) {
        int[] c;
        int k = 0;
        for (int j : arr) k = Math.max(k, j);
        c = new int[k + 1];
        for (int i = 0; i < c.length; i++)
            c[arr[i]]++;

        for (int i = 1; i < c.length; i++)
            c[i] += c[i - 1];
        int[] b = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = c[arr[i]];
            b[pos] = arr[i];
            c[arr[i]]--;
        }
        return b;
    }
}
