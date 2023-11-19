package com.example.stack;

public class MyStack {

    private int [] arr;
    private int capacity;
    private int top;

    public MyStack() {
        capacity = 16;
        arr = new int[capacity];
    }

    public void push(int elm) {
        if (top < capacity)
            arr[top++] = elm;
        else {
            capacity *= 2;
            int[] newArr = new int[capacity];

            for (int i = 0; i < arr.length; i++)
                newArr[i] = arr[i];

            newArr[top++] = elm;
            arr = newArr;
        }
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr[--top];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
