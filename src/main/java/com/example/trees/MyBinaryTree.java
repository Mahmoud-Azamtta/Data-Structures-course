package com.example.trees;

import java.util.ArrayList;

public class MyBinaryTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private Node root;

    public void insert(int elm) {
        root = insert(root, elm);
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

//    public boolean insert(int elm) {
//        Node node = new Node(elm);
//        if (root == null) {
//            root = new Node(elm);
//            return true;
//        }
//        Node current = root;
//        while (true) {
//            if (elm < current.value) {
//                if (current.left == null) {
//                    current.left = node;
//                    return true;
//                }
//                current = current.left;
//            }
//            else {
//                if (current.right == null) {
//                    current.right = node;
//                    return true;
//                }
//                current = current.right;
//            }
//        }
//    }

    public boolean find(int elm) {
        if (root == null)
            return false;

        Node current = root;
        while (current != null) {
            if (current.value == elm)
                return true;
            if (elm < current.value) {
                current = current.left;
            }
            else
                current = current.right;
        }
        return false;
    }

    private boolean findNode(int elm, Node current) {
        if (current == null)
            return false;
        if (current.value == elm) {
            return true;
        }

        if (current.value < elm)
            return findNode(elm, current.left);
        else
            return findNode(elm, current.right);
    }

    private Node findPlace(int elm, Node current) {
        if (current.value < elm && current.left == null)
            return current;
        if (current.value > elm && current.right == null)
            return current;

        if (current.value < elm)
            return findPlace(elm, current.left);
        else if (current.value > elm)
            return findPlace(elm, current.right);
        else
            return null;

    }

    public void postOrderTraversal() { /* DFS */
        System.out.print("[ ");
        postOrder(root);
        System.out.print("]");
        System.out.println();
    }

    private void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public void inOrderTraversal() { /* DFS */
        System.out.print("[ ");
        inOrder(root);
        System.out.print("]");
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void preOrderTraversal() { /* DFS */
        System.out.print("[ ");
        preOrder(root);
        System.out.print("]");
        System.out.println();
    }

    private void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int searchMin() {
        if (root == null)
            throw new IllegalStateException();

        return searchMin(root);
    }

    // in a "Binary Search Tree" it is guaranteed than the left most node
    // holds the minimum value
    private int searchMin(Node root) {
        if (root.left == null)
            return root.value;

        return searchMin(root.left);
    }

    public int min() {
        if (root == null)
            throw new IllegalStateException();

        return min(root);
    }

    // to find the min element in  "Binary Tree"
    // in a "Binary Tree we have to find the min of the left and right subtrees
    // because it's not guaranteed that it is in the right order
    private int min(Node root) {
        if (root.left == null && root.right == null)
            return root.value;

        int left = min(root.left);
        int right = min(root.right);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equalTo(MyBinaryTree tree) {
        if (tree == null)
            return false;
        if (this.root == null && tree.root == null)
            return true;

        return equalTo(this.root, tree.root);
    }

    private boolean equalTo(Node t1, Node t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 != null && t2 != null)
            return t1.value == t2.value &&
                    (equalTo(t1.left, t2.left)) &&
                    (equalTo(t1.right, t2.right));

        return false;
    }

    public boolean validateBST() {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value > min && root.value < max)
            return validateBST(root.left, min, root.value) &&
                    validateBST(root.right, root.value, max);
        return false;
    }

    public ArrayList<Integer> nodesAtKDistance(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        nodesAtKDistance(root, k, list);
        return list;
    }

    private void nodesAtKDistance(Node root, int k, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (k == 0) {
            list.add(root.value);
            return;
        }
        nodesAtKDistance(root.left, k - 1, list);
        nodesAtKDistance(root.right, k - 1, list);
    }

    public void swapRoots() {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public void levelOrderTraversal() { /* BFS */
        System.out.print("[ ");
        for (int i = 0; i <= height(); i++) {
            for (int elm : nodesAtKDistance(i))
                System.out.print(elm + " ");
        }
        System.out.println("]");
    }

    public void balanceFactor() {
        balanceFactor(root);
    }

    private void balanceFactor(Node current) {
        if (current == null)
            return;
        balanceFactor(current.left);
        int heightOfLeft = heightOf(current.left);
        int heightOfRight = heightOf(current.right);
        System.out.println(current.value + "\t" + (heightOfRight - heightOfLeft));
        balanceFactor(current.right);
    }

    public void removeLeaf(int n) {
        root = removeLeaf(root, n);
    }

    private Node removeLeaf(Node root, int n) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null && root.value == n)
            return null;

        root.left = removeLeaf(root.left, n);
        root.right = removeLeaf(root.right, n);

        return root;
    }

    private int heightOf(Node node) {
        if (node == null)
            return -1;
        return Math.max(heightOf(node.left), heightOf(node.right)) + 1;
    }

    private static int maxSum;
    private static Node leafOfMaxPath;
    public static void maxSumPath(MyBinaryTree tree) {
        preorder(tree.root, 0);
        printMaxSumPath(tree.root, leafOfMaxPath.value);
    }

    private static void printMaxSumPath(Node current, int target) {
        if (current.value == target) {
            System.out.println(current.value);
            return;
        }

        if (target < current.value) {
            System.out.println(current.value);
            printMaxSumPath(current.left, target);
        }
        else {
            System.out.println(current.value);
            printMaxSumPath(current.right, target);
        }
    }

    private static void preorder(Node root, int sum) {
        if (root == null)
            return;
        if (root.left == null & root.right == null) {
            sum += root.value;
            if (sum > maxSum) {
                leafOfMaxPath = root;
                maxSum = sum;
            }
            return;
        }

        sum += root.value;
        preorder(root.left, sum);
        preorder(root.right, sum);
    }
}
