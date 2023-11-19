package com.example.Assignments;

public class Main {
    public static void main(String[] args) {
        System.out.println("Question one (rotateRight):");
        MyArrayList arrayList = new MyArrayList(new Integer[] {1, 2, 3, 4, 5, 6});
        System.out.println("The initial state of the ArrayList:");
        arrayList.print();
        System.out.println("After rotating by k = 3:");
        rotate(arrayList, 4);
        arrayList.print();

        System.out.println("------------------------------------------");
        System.out.println("Question two (middleLinkedList)");
        MyLinkedList linkedList = new MyLinkedList(new int[] {1, 2, 3, 4, 5, 6});
        System.out.println("My LinkedList is:");
        linkedList.print();
        System.out.println("The value of the mid node is: ");
        System.out.println(linkedList.middleLinkedList());

        System.out.println("------------------------------------------");
        System.out.println("Question three(mergeLinkedLists):");
        MyLinkedList list1 = new MyLinkedList(new int[] {3, 1, 2, 5});
        MyLinkedList list2 = new MyLinkedList(new int[] {9, 4, 6, 7, 0});
        System.out.println("list1 before:");
        list1.print();
        System.out.println("list2 before:");
        list2.print();
        System.out.println("After sorting both lists and merging:");
        MyLinkedList.mergeTwoSortedLists(list1, list2).print();

    }

    public static void rotate(MyArrayList list, int k) {
        if (list.isEmpty())
            return;
        if (k % list.getSize() == 0)
            return;
        MyArrayList rotated = new MyArrayList(list.getSize());

        k = k % list.getSize();
        for (int i = k; i < list.getSize(); i++) {
            rotated.add(list.get(i));
        }

        for (int i = 0; i < k; i++) {
            rotated.add(list.get(i));
        }
        list.setArr(rotated.getArr());
    }
}
