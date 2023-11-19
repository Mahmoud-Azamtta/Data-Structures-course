package com.example.trie;

import java.util.Locale;

public class Trie {

    private static class Node {
        char value;
        final Node[] children;
        boolean isLastChar;
        Node() {
            this.children = new Node[ALPHABET_SIZE];
        }

        Node(char value) {
            this.value = value;
            this.children = new Node[ALPHABET_SIZE];
        }
    }

    private Node root;
    public static int ALPHABET_SIZE = 26;

    public Trie() {
        this.root = new Node();
    }

    /** Iterative Approach **/
    public void insert(String word) {
        if (word.isEmpty())
            return;
        Node current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null)
                current.children[idx] = new Node(c);
            current = current.children[idx];
        }
        current.isLastChar = true;
    }
    /** My Approach (Recursive) **/
//    public void insert(String word) {
//        if (word.isEmpty())
//            return;
//
//        insert(root, word.toLowerCase(), 0);
//    }
//
//    private void insert(Node node, String word, int idx) {
//        if (idx == word.length())
//            return;
//
//        int pos = word.charAt(idx) - 'a';
//        if (node.children[pos] == null) {
//            node.children[pos] = new Node(word.charAt(idx));
//        }
//
//        insert(node.children[pos], word, idx + 1);
//    }
//
//    private boolean isLeaf(Node node) {
//        for (Node curr : node.children) {
//            if (curr != null)
//                return false;
//        }
//
//        return true;
//    }
}
