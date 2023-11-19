package com.example.linkedlist;

import java.util.NoSuchElementException;

public class GenericLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void addFirst(E elm) {
        Node<E> node = new Node<>(elm);

        if (isEmpty())
            first = last = node;

        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(E elm) {
        Node<E> node = new Node<>(elm);

        if (isEmpty())
            first = last = node;

        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            Node<E> node = first.next; // the second node
            first.next = null;
            first = node;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;

        else {
            Node<E> node = first;
            while (node != null) {
                if (node.next == last)
                    break;
                node = node.next;
            }
            node.next = null;
            last = node;
        }
        size--;
    }

    public boolean contains(E elm) {
        if (isEmpty())
            return false;
        else {
            Node<E> node = first;
            while (node != null) {
                if (node.data == elm)
                    return true;
                node = node.next;
            }
        }
        return false;
    }

    public int indexOf(E elm) {
        if (isEmpty())
            return -1;

        int index = 0;
        Node<E> node = first;
        while (node != null) {
            if (node.data == elm)
                return index;
            index++;
            node = node.next;
        }
        return -1;
    }

    public E first() {
        if (isEmpty())
            return null;
        return first.data;
    }

    public E last() {
        if (isEmpty())
            return null;
        return last.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
