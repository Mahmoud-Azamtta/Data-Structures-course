package com.example.lab;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(new ArrayList<>(Arrays.asList(4, 1, 6, 2, 7)));
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(7);
        stack.push(8);

        sortQueue(queue);
        System.out.println(queue);
    }

    public static void sortQueue(Queue<Integer> q) {
        if (q.isEmpty())
            return;
        int temp = q.remove();
        sortQueue(q);
        insertInQueue(q, temp);
    }

    public static void insertInQueue(Queue<Integer> q, int i) {
        if (q.isEmpty() || i > q.peek()) {
            q.add(i);
            return;
        }
        int temp = q.remove();
        insertInQueue(q, i);
        q.add(temp);
    }

    public static LinkedList<Integer> reverseStackInLinkedList(Stack<Integer> stack) {
        LinkedList<Integer> list = new LinkedList<>();
        recurse(stack, list);
        return list;
    }

    public static void recurse(Stack<Integer> stack, LinkedList<Integer> list) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        recurse(stack, list);
        insert(stack, list, temp);
    }

    public static void insert(Stack<Integer> stack, LinkedList<Integer> list, int i) {
        if (stack.isEmpty() || i > stack.peek()) {
            stack.push(i);
            list.add(i);
            return;
        }
        int temp = stack.pop();
        insert(stack, list, temp);
        stack.push(i);
        list.add(i);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int temp = queue.remove();
        reverseQueue(queue);
        queue.add(temp);
    }

    public static void insertAtBottom(Stack<Integer> stack, int i) {
        if (stack.isEmpty()) {
            stack.push(i);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, i);
        stack.push(temp);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    public static int occurrenceOf(char c, String str, int start) {
        if (start == str.length())
            return -1;
        if (str.charAt(start) == c)
            return start;

        return occurrenceOf(c, str, start + 1);
    }

    public static int binarySearch (ArrayList<Integer> list, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        int element = list.get(mid);
        if (element == target)
            return mid;
        else if (element < target)
            return binarySearch(list, mid + 1, right, target);
        else
            return binarySearch(list, left, mid - 1, target);
    }

    public static boolean checkIfPalindrome(String str, int l, int r) {
        if (l == r || l > r)
            return true;

        if (str.charAt(l) != str.charAt(r))
            return false;

        return checkIfPalindrome(str, l + 1, r - 1);
    }

    public static void reverseString(String str) {
        if (str.length() <= 1)
            System.out.print(str);
        else {
            System.out.print(str.charAt(str.length() - 1));
            reverseString(str.substring(0, str.length() - 1));
        }
    }

    public static void insert(Stack<Integer> stack, int top) {
        if (stack.isEmpty() || top > stack.peek()) {
            stack.push(top);
            return;
        }

        int temp = stack.pop();
        insert(stack, top);
        stack.push(temp);
    }

    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int top = stack.pop();
        sort(stack);
        insert(stack, top);
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int temp = queue.remove();
        reverse(queue);
        queue.add(temp);
    }

    public static void printPrime(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int num = stack.pop();
        if (isPrime(num)) {
            System.out.println(num);
        }
        printPrime(stack);
        stack.push(num);
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
