package com.example.trees;

public class AVLTree {
    private static class AVLNode {
        int height;
        int value;
        AVLNode left;
        AVLNode right;

        AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value +
                    ", height=" + height;
        }
    }

    private AVLNode root;

    public void insert(int elm) {
        root = insert(root, elm);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        // to give every node we add to the tree a value for its height
        root.height = setHeight(root);

        root = balance(root);

        return root;
    }

    private AVLNode balance(AVLNode root) {
        if (isRightHeavy(root)) {
            if (balanceFactor(root.right) < 0)
                root.right = rightRotate(root.right);
                //System.out.println("rightRotate(" + root.right.value + ")");
            return leftRotate(root);
            //System.out.println("leftRotate(" + root.value + ")");
        }
        else if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) > 0)
                root.left = leftRotate(root.left);
                //System.out.println("leftRotate(" + root.left.value + ")");
            return rightRotate(root);
            //System.out.println("rightRotate(" + root.value +")");
        }
        return root;
    }

    private AVLNode rightRotate(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        newRoot.height = setHeight(newRoot);
        root.height = setHeight(root);

        return newRoot;
    }

    private AVLNode leftRotate(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        newRoot.height = setHeight(newRoot);
        root.height = setHeight(root);

        return newRoot;
    }

    private int setHeight(AVLNode node) {
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    public void print() {
        inorder(root);
    }

    private void inorder(AVLNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }
}
