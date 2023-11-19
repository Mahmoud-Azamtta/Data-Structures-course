package com.example.lab;

public class MyLinkedList {

    private static class Node {
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
    }

    public MyLinkedList(int[] arr) {
        for (int i : arr) {
            this.addLast(i);
        }
    }

    public void addFirst(Integer elm) {
        Node temp = new Node(elm);

        if (head == null) {
            head = tail = temp;
        }
        else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void addLast(Integer elm) {
        Node temp = new Node(elm);

        if (head == null)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void addAt(int index, Integer elm) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();

        if (index == 0)
            addFirst(elm);
        if (index == size)
            addLast(elm);

        else {
            Node temp = new Node(elm);
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;

            temp.next = prev.next;
            prev.next = temp;
            size++;
        }
    }

    public Integer get(int index) {
        if (index < 0 || index > size)
            throw new IllegalStateException();

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.value;
    }

    public void set(int index, Integer value) {
        if (index < 0 || index > size)
            throw new IllegalStateException();

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.value = value;
    }

    public Integer removeFirst() {
        if (size == 0)
            throw new IllegalStateException();

        Integer elm = head.value;
        Node temp = head.next;
        head.next = null;
        head = temp;
        size--;
        return elm;
    }

    public Integer removeLast() {
        if (size == 0)
            throw new IllegalStateException();

        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }

        Integer elm = tail.value;
        prev.next = null;
        tail = prev;
        size--;
        return elm;
    }

    public Integer removeAt(int index) {
        if (index < 0 || index > size)
            return null;
        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        Node curr = prev.next;
        Integer elm = curr.value;

        prev.next = curr.next;
        curr.next = null;

        size--;
        return elm;
    }

    public boolean contains(Integer elm) {
        if (size == 0)
            return false;

        Node curr = head;
        while (curr != null) {
            if(curr.value.equals(elm))
                return true;
            curr = curr.next;
        }
        return false;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }

    public void swapTwoNodes(int l, int r) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node right = head;
        Node left = head;
        Node rightPrev = dummy;
        Node leftPrev = dummy;

        for (int i = 0; i < r - 1; i++) {
            rightPrev = right;
            right = right.next;
        }

        for (int i = 0; i < l - 1; i++) {
            leftPrev = left;
            left = left.next;
        }

        Node rightFront = right.next;
        Node leftFront = left.next;

        left.next = rightFront;
        right.next = leftFront;
        rightPrev.next = left;
        leftPrev.next = right;

        head = dummy.next;
    }

    public int middleLinkedList() {
        if (head.next == null)
            return head.value;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }

    public void sortLinkedList() {
        Node first = head;

        while (first != null) {
            Node min = first;
            Node second = first.next;
            while (second != null) {
                if (second.value < min.value)
                    min = second;
                second = second.next;
            }
            if (!min.value.equals(first.value)) {
                int temp = first.value;
                first.value = min.value;
                min.value = temp;
            }
            first = first.next;
        }
    }

    public static MyLinkedList mergeTwoSortedLists(MyLinkedList list1, MyLinkedList list2) {
        list1.sortLinkedList();
        list2.sortLinkedList();

        MyLinkedList merged = new MyLinkedList();

        Node head1 = list1.head;
        Node head2 = list2.head;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                merged.addLast(head2.value);
                head2 = head2.next;
            }
            else if (head2 == null) {
                merged.addLast(head1.value);
                head1 = head1.next;
            }
            else if (head1.value < head2.value) {
                merged.addLast(head1.value);
                head1 = head1.next;
            }
            else {
                merged.addLast(head2.value);
                head2 = head2.next;
            }
        }
        return merged;
    }

    public int size() {
        return size(head);
    }

    private int size(Node head) {
        if (head == null)
            return 0;

        return 1 + size(head.next);
    }
}
