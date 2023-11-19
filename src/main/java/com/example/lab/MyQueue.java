package com.example.lab;

public class MyQueue {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(int value) {
        Node node = new Node(value);

        if (front == null)
            front = rear = node;

        else {
            rear.next = node;
            rear = rear.next;
        }
        size++;
    }

    public int dequeue() {
        if (front.next == null) {
            int temp = front.value;
            front = null;
            size--;
            return temp;
        }

        int value = front.value;
        front = front.next;
        size--;
        return value;
    }

    public int peek() {
        return front.value;
    }

    public boolean isEmpty() {
        return rear == null;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node node = front;
        while (node != null) {
            if (node.next == null)
                str.append(node.value);
            else
                str.append(node.value + " , ");
            node = node.next;
        }
        str.append("]");
        return str.toString();
    }
}
