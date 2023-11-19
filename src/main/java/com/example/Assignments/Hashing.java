package com.example.Assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Hashing {
    private final Random random;
    private final ArrayList<Integer> array;
    private final ArrayList<LinkedList<Integer>> hashedArray;
    private long arrayComparisons;
    private int hashedArrayComparisons;

    private final int CAPACITY = 1019;
    private final int MAX = 1000;
    private final int MIN = 1;

    public Hashing() {
        array = new ArrayList<>(CAPACITY);
        hashedArray = new ArrayList<>(CAPACITY);
        random = new Random();
    }

    public void getAverageComparisons() {
        fillArray();
        init();
        fillHashedArray();
        setArrayComparisons();
        setHashedArrayComparisons();

        double arrayAverage = (double)(arrayComparisons) / CAPACITY;
        double hashedAverage = (double)(hashedArrayComparisons) / CAPACITY;

        printInfo(arrayAverage, hashedAverage);
    }

    private void printInfo(double arrayAverage, double hashedAverage) {
        System.out.println("Total comparisons performed in the normal array: " + arrayComparisons);
        System.out.print("Average: ");
        System.out.printf("%.2f\n", arrayAverage);
        System.out.println("Total comparisons performed in the hashed array: " + hashedArrayComparisons);
        System.out.print("Average: ");
        System.out.printf("%.2f\n", hashedAverage);

    }

    private void setHashedArrayComparisons() {
        for (int i = 0; i < CAPACITY; i++) {
            int value = random.nextInt(MAX - MIN) + MIN;
            int index = hashFunction(value);
            LinkedList<Integer> list = hashedArray.get(index);
            if (list.size() == 0) {
                hashedArrayComparisons++;
                continue;
            }
            if (list.size() == 1) {
                hashedArrayComparisons++;
            }
            else {
                for (int n : list) {
                    hashedArrayComparisons++;
                    if (n == value)
                        break;
                }
            }
        }
    }

    private void setArrayComparisons() {
        for (int i = 0; i < CAPACITY; i++) {
            int value = random.nextInt(MAX - MIN) + MIN;
            for (int n : array) {
                arrayComparisons++;
                if (n == value) {
                    break;
                }
            }
        }
    }

    private void fillArray() {
        for (int i = 0; i < CAPACITY; i++) {
            array.add(random.nextInt(MAX - MIN) + MIN);
        }
    }

    private void fillHashedArray() {
        for(int i = 0; i < CAPACITY; i++) {
            int value = random.nextInt(MAX - MIN) + MIN;
            int index = hashFunction(value);
            hashedArray.get(index).add(value);
        }
    }

    private void init() {
        for (int i = 0; i < CAPACITY; i++) {
            hashedArray.add(new LinkedList<>());
        }
    }

    private int hashFunction(Integer i) {
        return Math.abs(i.hashCode() % CAPACITY);
    }

    public static void main(String[] args) {
        Hashing hashing = new Hashing();
        hashing.getAverageComparisons();
    }
}
