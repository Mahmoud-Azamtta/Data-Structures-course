package com.example.Assignments;

import com.example.lab.NewArrayList;

import java.util.ArrayList;

public class MyArrayList {
    private Integer[] arr;
    private final int capacity = 5;
    private int size;

    public MyArrayList() {
        arr = new Integer[capacity];
    }

    public MyArrayList(int capacity) {
        arr = new Integer[capacity];
    }

    public MyArrayList(Integer[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    public void add(int elm) {
        if (arr.length == size) {
            ensureCapacity();
        }
        arr[size++] = elm;
    }

    public void addAt(int elm, int index) {
        if (index == size)
            add(elm);
        else if (size == arr.length) {
            ensureCapacity();
        }
        for (int i = size; i >= index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = elm;
        size++;
    }

    public int removeAt(int index) {
        if (size == 0)
            throw new IllegalStateException();
        int value = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return value;
    }

    public void removeByValue(int elm) {
        for (int i = 0; i < arr.length; i++) {
            if (elm == arr[i]) {
                removeAt(i);
                break;
            }
        }
    }

    public int indexOf(int elm) {
        if (size == 0)
            throw new IllegalStateException();
        for (int i = 0; i < size; i++) {
            if (arr[i] == elm)
                return i;
        }
        return -1;
    }

    public int lastIndexOf(int elm) {
        if (size == 0)
            throw new IllegalStateException();
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == elm)
                return i;
        }
        return -1;
    }

    public void set(int elm, int index) {
        if (index >= size)
            throw new IllegalStateException("index out of bound");
        arr[index] = elm;
    }

    public Integer get(int index) {
        if (index >= size)
            throw new IllegalStateException("index out of bound");
        return arr[index];
    }

    public boolean contains(int elm) {
        if (size == 0)
            throw new IllegalStateException();
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(elm))
                return true;
        }
        return false;
    }

    public void removeDuplicate() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i].equals(arr[j]) && i != j)
                    removeAt(j);
            }
        }
    }

    private void ensureCapacity() {
        Integer[] temp = new Integer[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void clear() {
        if (size == 0)
            return;
        arr = new Integer[capacity];
        size = 0;
    }

    public boolean containsAll(ArrayList<Integer> list) {
        if (this.isEmpty())
            return false;

        for (int i : list) {
            if (this.contains(i))
                return false;
        }

        return true;
    }

    public boolean containsAll(NewArrayList list) {
        if (list.isEmpty() && this.isEmpty())
            return true;
        for (int i = 0; i < list.getSize(); i++) {
            if (!this.contains(list.get(i)))
                return false;
        }
        return true;
    }

    public boolean retainALl(Integer[] arr) {
        if (this.isEmpty())
            return false;

        int removed = 0;
        for (int i = 0; i < this.getSize(); i++) {
            boolean contain = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(get(i))) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                this.removeAt(i);
                removed++;
            }
        }
        return removed > 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
