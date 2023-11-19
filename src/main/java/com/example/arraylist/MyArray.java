package com.example.arraylist;

public class MyArray {
    private int length;
    private int index;
    private int[] arr;

    public MyArray(int length) {
        this.length = length;
        this.arr = new int[this.length];
        this.index = 0;
    }

    public void insert(int elm) {
        System.out.println(this.index);
        if (this.index < this.length) {
            this.arr[index] = elm;
        }
        else {
            int newLen = this.length + 1;
            int[] newArr = new int[newLen];

            for (int i = 0; i < this.length; i++) {
                newArr[i] = this.arr[i];
            }
            newArr[newLen - 1] = elm;

            this.length = newLen;
            this.arr = newArr;
        }
        this.index++;
    }

    public void removeAt(int index) {
        if (index >= this.length) {
            return;
        }
        else {
            int newLen = this.length - 1;
            int[] newArr = new int[newLen];
            int newIndex = 0;
            int oldIndex = 0;

            while (oldIndex < this.length) {
                if (oldIndex == index) {
                    oldIndex++;
                }
                else {
                    newArr[newIndex] = this.arr[oldIndex];
                    newIndex++;
                    oldIndex++;
                }
            }
            this.length = newLen;
            this.arr = newArr;
            this.index--;
        }
    }

    public int indexOf(int elm) {
        for (int i = 0; i < this.length; i++) {
            if (this.arr[i] == elm)
                return i;
        }
        return -1;
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < this.index; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
