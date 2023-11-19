package com.example.trees;

public class TreeTest {
    public static void main(String[] args) {
        MyBinaryTree t = new MyBinaryTree();
        t.insert(4);
        t.insert(2);
        t.insert(3);
        t.insert(1);
        t.insert(5);

        t.removeLeaf(3);

        t.inOrderTraversal();

//        t.inorder();
//        t.rotateEvenOdd();
//        t.inorder();

//        TreeNode root = new TreeNode(8);
//        TreeNode l1 = root.left = new TreeNode(5);
//        TreeNode r1 = root.right = new TreeNode(16);
//
//        TreeNode l2 = l1.left = new TreeNode(3);
//        TreeNode r2 = l1.right = new TreeNode(7);
//        TreeNode l3 = r1.left = new TreeNode(12);
//        TreeNode r3 = r1.right = new TreeNode(20);
//
//        TreeNode l4 = l2.left = new TreeNode(2);
//        TreeNode l5 = r2.left = new TreeNode(4);
//        TreeNode l6 = l3.left = new TreeNode(10);
//        TreeNode r4 = l3.right = new TreeNode(13);
//        TreeNode l7 = r3.left = new TreeNode(17);
//        TreeNode r5 = r3.right = new TreeNode(24);
//
//        inorder(root);
//        System.out.println();
//        System.out.println(kthLargest(root, 3));
//        count = 0;
    }
}
