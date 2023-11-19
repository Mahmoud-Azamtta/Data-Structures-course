package com.example.arraylist;

public class Array {
    private int[] arr;
    private int index;

    public Array(int length) {
        this.arr = new int[length];
    }

    public void insert(int elm) {
        if (index < arr.length)
            arr[index++] = elm;
        else {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index++] = elm;
            arr = newArr;
        }
    }

    public void removeAt(int i) {
        if (i < 0 || i >= index)
            throw new ArrayIndexOutOfBoundsException("index " + i + " is out of the array bound");
        if (i == index -1)
            index--;
        else {
            for (int j = i; j < index; j++) {
                arr[j] = arr[j + 1];
            }
            index--;
        }
    }

    public int indexOf(int elm) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == elm)
                return i;
        }
        return -1;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < index; i++) {
            if (i == index - 1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public int size() {
        return this.index;
    }
}
