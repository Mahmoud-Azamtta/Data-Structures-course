package com.example.Assignments;

public class Assignment2Main {
    public static void main(String[] args) {
        Bst tree = new Bst();
        tree.insert(10);
        tree.insert(7);
        tree.insert(13);
        tree.insert(11);
        tree.insert(5);
        tree.insert(8);
        tree.insert(4);
        tree.insert(6);
        tree.insert(9);

        tree.balanceFactor();

//        System.out.println("Maximum sum paths in the tree:");
//        tree.printMaxSumPaths();
//        System.out.println("ZigZag traversal on the tree:");
//        tree.zigZagTraversal();
    }
}
