package com.example.stacks.questions;

import java.util.Stack;

public class StringReverser {
    public static void main(String[] args) {
        String str = "abcd";
        Stack<Character> stack = new Stack<>();
        String reversed = "";

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            reversed += stack.pop();
        }

        System.out.println(reversed);
        System.out.println(reverse(str));
    }

    // a more efficient way:
    public static String reverse(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
            stack.push(c);

        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}
