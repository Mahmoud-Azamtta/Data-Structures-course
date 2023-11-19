package com.example.Assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBST {
    private TNode root;
    private static class TNode {
        int value;
        TNode left;
        TNode right;
        TNode(int value) {
            this.value = value;
        }
    }
    private int maxPath;
    public void printMaxSumPaths() {
        maxSum(root, 0);
        maxSumPaths(root, maxPath);
    }

    private void maxSumPaths(TNode current, int max) {
        if (current == null)
            return;
        if (current.left == null && current.right == null) {
            max -= current.value;
            if (max == 0) {
                System.out.println("A max sum path: ");
                printPath(root, current);
            }
            return;
        }

        max -= current.value;
        maxSumPaths(current.left, max);
        maxSumPaths(current.right, max);
    }

    private void maxSum(TNode current, int sum) {
        if (current == null)
            return;

        if (current.left == null && current.right == null) {
            sum += current.value;
            if (maxPath < sum)
                maxPath = sum;
            return;
        }

        sum += current.value;
        maxSum(current.left, sum);
        maxSum(current.right, sum);
    }

    private void printPath(TNode current, TNode leaf) {
        if (current == leaf) {
            System.out.println(current.value);
            return;
        }

        if (leaf.value < current.value) {
            System.out.println(current.value);
            printPath(current.left, leaf);
        }

        else {
            System.out.println(current.value);
            printPath(current.right, leaf);
        }
    }

    private Stack<Integer> stack = new Stack<>();
    private Queue<Integer> queue = new LinkedList<>();

    private int height(TNode current) {
        if (current == null)
            return -1;

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

        if (leftHeight < rightHeight)
            return rightHeight + 1;
        else
            return leftHeight + 1;
        //return 1 + Math.max(height(current.left), height(current.right));
    }

    private void fillStack(TNode current, int i) {
        if (current == null)
            return;
        if (i == 0) {
            stack.push(current.value);
            return;
        }
        fillStack(current.left, i - 1);
        fillStack(current.right, i - 1);
    }

    private void fillQueue(TNode current, int i) {
        if (current == null)
            return;
        if (i == 0) {
            queue.add(current.value);
            return;
        }
        fillQueue(current.left, i - 1);
        fillQueue(current.right, i - 1);
    }

    public void zigZagTraversal() {
        int n = height(root);
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                fillQueue(root, i);
                while (!queue.isEmpty())
                    System.out.print(queue.remove() + " ");
            }
            else {
                fillStack(root, i);
                while (!stack.isEmpty())
                    System.out.print(stack.pop() + " ");
            }
        }
        System.out.println();
    }

    private int kthLargest;
    private int counter;
    public int kthLargestElement(int k) {
        kthLargestElement(root, k);
        return kthLargest;
    }

    private void kthLargestElement(TNode current, int k) {
        if (current == null || counter >= k)
            return;

        kthLargestElement(current.right, k);
        counter++;
        if (counter == k) {
            kthLargest = current.value;
            return;
        }

        kthLargestElement(current.left, k);
    }

    public void insert(int elm) {
        root = insert(root, elm);
    }

    private TNode insert(TNode root, int value) {
        if (root == null)
            return new TNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);

        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    public void printSubTrees() {
        printSub(root);
    }

    private void printSub(TNode root) {
        if (root == null)
            return;

        printSub(root.left);
        if (root.left == null && root.right == null)
            return;
        sub(root);
        System.out.println();
        printSub(root.right);
    }

    private void sub(TNode node) {
        if (node == null)
            return;

        sub(node.left);
        System.out.print(node.value + " ");
        sub(node.right);
    }

    public void rotateEvenOdd() {
        rotate(root);
    }

    private void rotate(TNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        if (root.left != null && root.left.value % 2 == 0)
            root.left = rotateRight(root.left);
        else if (root.left != null && root.left.value % 2 == 1)
            root.left = rotateLeft(root.left);

        if (root.right != null && root.right.value % 2 == 0)
            root.right = rotateRight(root.right);
        else if (root.right != null && root.right.value % 2 == 1)
            root.right = rotateLeft(root.right);

        rotate(root.left);
        rotate(root.right);
    }

    private TNode rotateRight(TNode node) {
        if (node.left == null && node.right == null)
            return node;
        TNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        return newRoot;
    }

    private TNode rotateLeft(TNode node) {
        if (node.right == null)
            return node;
        TNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        return newRoot;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(TNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }
}
