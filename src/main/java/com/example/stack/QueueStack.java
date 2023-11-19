package com.example.stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> stack;
    private Queue<Integer> temp;

    public QueueStack() {
        stack = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        if (empty())
            throw new IllegalStateException();

        while (stack.size() != 1)
            temp.add(stack.remove());
        int value = stack.remove();

        while (!temp.isEmpty())
            stack.add(temp.remove());
        return value;
    }

    public int top() {
        if (empty())
            throw new IllegalStateException();

        while (stack.size() != 1)
            temp.add(stack.remove());
        int value = stack.peek();
        temp.add(stack.remove());
        while (!temp.isEmpty())
            stack.add(temp.remove());
        return value;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
