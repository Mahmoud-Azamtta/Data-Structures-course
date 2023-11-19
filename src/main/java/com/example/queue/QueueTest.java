package com.example.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueTest {
    public static void main(String[] args) {

        // todo reverse a queue

        com.example.queue.Queue queue = new LinkedQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty())
            System.out.println(queue.remove());


        /*
        * queue.enqueue(4);
        * queue.enqueue(5);
        * queue.enqueue(1);
        * queue.enqueue(3);
        * queue.enqueue(2);
        * queue.enqueue(2);

        * System.out.println(queue.remove());
        * System.out.println(queue.remove());
        * System.out.println(queue.remove());
        * System.out.println(queue.remove());
        * System.out.println(queue.remove());
        * System.out.println(queue.remove());
        */

        //System.out.println(queue);
        //reverse(queue);
        //System.out.println(queue);
    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
