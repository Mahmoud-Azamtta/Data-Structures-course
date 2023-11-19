package com.example.linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    //todo addLast
    //todo addFirst
    //todo deleteLast
    //todo deleteFirst
    //todo contains
    //todo indexOf

    private static class Node {
        int value;
        Node next;

        Node (int value) {
            this.value = value;
        }
    }

    public void addLast(int elm) {
        Node node = new Node(elm);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int elm) {
        Node node = new Node(elm);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        Node previous = getPrevious(last);
        previous.next = null;
        last = previous;
        size--;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public boolean contains(int elm) {
//        Node current = first;
//        while (current.next != null) {
//            if(current.value == elm) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;

        // or we can use the method indexOf:
        return indexOf(elm) != -1;
    }

    public int indexOf(int elm) {
        int counter = 0;
        Node current = first;
        while (current != null) {
            if (current.value == elm)
                return counter;
            counter++;
            current = current.next;
        }
        return -1;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node node = first;
        int index = 0;
        while (node != null) {
            arr[index++] = node.value;
            node = node.next;
        }
        return arr;
    }

    public void reverse() {
        if (isEmpty())
            return;

        Node previous = first;
        Node current = first.next;

        while (current != null) {
            Node n = current.next;
            current.next = previous;
            previous = current;
            current = n;
        }

        // after reversing the links using the algorithm above
        // "first" and "last" didn't change, so we have to swap them
        // also "first" is still pointing to the second node
        last = first;
        last.next = null;
        first = previous; // "previous" after reversing the links is pointing to "last"
                          // so we make it point to first
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        /*
         we can add this condition if it was mentioned that
         we can't take negative values, but the method still works without it,
         the method will simply return the last element in the list
                if (k < 0) // we can make the boolean condition (k < 0 || k > size)
                           // but in some interviews they add to the problem
                           // "assuming that you don't know the size of the linked list"
                    throw new IndexOutOfBoundsException();
        */

        Node left = first;
        Node right = first;
        for (int i = 0; i < k - 1; i++) {
            right = right.next;
            if (right == null)
                throw new IllegalArgumentException();
        }

        while (right != last) {
            right = right.next;
            left = left.next;
        }
        return left.value;
    }

    public void rotate(int k) {
        if (first == null)
            throw new IllegalStateException();

        if (k >= size) {
            k %= size;
        }

        Node left = first;
        Node right = first;

        while (k != 0) {
            right = right.next;
            k--;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        right.next = first;
        first = left.next;
        left.next = null;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node node = first;

        while (node != null) {
            String temp;
            if (node.next == null) {
                temp = node.value + " -> null";
            }
            else {
                temp = node.value + " -> ";
            }
            str.append(temp);
            node = node.next;
        }
        str.append("]");
        return str.toString();
    }

    protected int first() {
        if (isEmpty())
            throw new IllegalStateException();
        return first.value;
    }
}
