package com.example.leetcode;

import java.util.Stack;

public class MinStack {
    private Stack<int[]> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
            min = val;
            return;
        }

        int currentMin = Math.min(min, val);
        stack.push(new int[] {val, currentMin});
        min = currentMin;
    }

    public void pop() {
        stack.pop();
        min = this.getMin();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {

        return stack.peek()[1];
    }
}
