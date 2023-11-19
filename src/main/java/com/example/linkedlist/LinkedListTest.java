package com.example.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListTest {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        int[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));
        list.rotate(2);
        int[] arr2 = list.toArray();
        System.out.println(Arrays.toString(arr2));

    }
}
