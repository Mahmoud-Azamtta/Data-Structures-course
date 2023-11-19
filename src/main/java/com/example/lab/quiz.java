package com.example.lab;

import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.util.*;

public class quiz {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 100, 3, 5, 6, 23, 9));
        System.out.println(findMax(list, 0));

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        pushFirst(stack, 5);

        System.out.println(stack);
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));

        System.out.println(isPal(queue));
    }

    public static int findMax(ArrayList<Integer> arr, int max) {
        if (arr.size() == 0)
            return max;

        return max = Math.max(arr.remove(0), findMax(arr, max));
    }

    public static void pushFirst(Stack<Integer> stack, int elm) {
        if (stack.isEmpty()) {
            stack.push(elm);
            return;
        }
        int temp = stack.pop();
        pushFirst(stack, elm);
        stack.push(temp);
    }


    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int temp = queue.remove();
        reverse(queue);
        queue.add(temp);
    }

    public static boolean isPal(Queue<Integer> queue) {
        String str = "";
        for (int i : queue)
            str += i;
        reverse(queue);

       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) - 48 != queue.remove())
               return false;
       }
       return true;
    }
}
