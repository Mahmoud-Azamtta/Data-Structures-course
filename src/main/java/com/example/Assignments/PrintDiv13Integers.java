package com.example.Assignments;

import java.util.Random;

public class PrintDiv13Integers extends Thread {
    private final int n1;
    private final int n2;
    private final int objectNumber;
    private static int counter;
    public PrintDiv13Integers(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        objectNumber = ++counter;
    }
    @Override
    public void run() {
        for (int i = n1; i < n2; i++) {
            if (i % 13 == 0) {
                System.out.println(i + " from " + objectNumber);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        PrintDiv13Integers[] arr = new PrintDiv13Integers[10];
        final int min = 100;
        final int max = 1000;
        int n1 = random.nextInt(max - min) + min;
        int n2 = random.nextInt(max - min) + min;
        while (n2 < n1) {
            n2 = random.nextInt(max - min) + min;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new PrintDiv13Integers(n1, n2);
        }

        for (PrintDiv13Integers p : arr) {
            p.start();
        }
    }
}
