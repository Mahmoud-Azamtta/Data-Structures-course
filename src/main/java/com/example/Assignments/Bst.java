package com.example.Assignments;

public class Bst {
    private Node root;
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public void balanceFactor() {
        balanceFactor(root);
    }

    private void balanceFactor(Node node) {
        if (node == null)
            return;

        balanceFactor(node.left);
        System.out.println("balance factor of " + node.value + " is " + (height(node.right) - height(node.left)));
        balanceFactor(node.right);
    }

    private int height(Node current) {
        if (current == null)
            return -1;

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

        if (leftHeight < rightHeight)
            return rightHeight + 1;
        else
            return leftHeight + 1;
    }
}
