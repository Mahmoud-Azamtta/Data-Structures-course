package com.example.stack;

import com.example.linkedlist.GenericLinkedList;

public class LinkedListStack<E> implements Stack<E>{
    private GenericLinkedList<E> list = new GenericLinkedList<>();

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        E popped = list.first();
        list.deleteFirst();
        return popped;
    }

    @Override
    public E peek() {
        return list.first();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
