package com.example.trie;

import java.util.*;

public class MapTrie {

    private static class Node {
        char value;
        final Map<Character, Node> children;
        boolean isLastChar;

        Node(char value) {
            this.children = new HashMap<>();
            this.value = value;
        }

        /**
         * I'm using these methods to not violate the OOP design abstraction principle
         **/
        // to achieve abstraction the details and logic of a class must be hidden from the user
        // that means in the insert  operation below I can't work with the children map directly
        // because it's an implementation detail of the Node class
        // keep in mind that this class must not be an inner class if we want to make it abstract
        // but, it's just for practice
        boolean hasChild(char c) {
            return children.containsKey(c);
        }

        Node getChild(char c) {
            return children.get(c);
        }

        void createChild(char c) {
            children.put(c, new Node(c));
        }

        Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        boolean isLeaf() {
            return children.isEmpty();
        }

        void removeChild(char c) {
            children.remove(c);
        }

        @Override
        public String toString() {
            return "value: " + value;
        }
    }

    private final Node root;

    public MapTrie() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.hasChild(c))
                current.createChild(c);
            current = current.getChild(c);
        }
        current.isLastChar = true;
    }

    public boolean contains(String word) {
        if (word == null || word.length() == 0)
            return false;
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.hasChild(c))
                return false;
            current = current.getChild(c);
        }

        return current.isLastChar;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        System.out.println(node.value);
        for (Node current : node.getChildren())
            traverse(current);
    }

    public void delete(String word) {
        if (word == null)
            return;
        delete(root, word, 0);
    }

    private void delete(Node node, String word, int idx) {
        if (idx == word.length()) {
            // node won't be null, it will be the node that holds the last char
            // in the word since we started traversing from the root
            // and root does not hold any characters
            node.isLastChar = false;
            return;
        }
        Node current = node.getChild(word.charAt(idx));
        if (current == null)
            return;
        delete(current, word, idx + 1);
        if (current.isLeaf() && !current.isLastChar)
            node.removeChild(word.charAt(idx));
    }

    public List<String> autoComplete(String prefix) {
        if (prefix == null)
            return new ArrayList<>();
        Node last = lastNode(prefix);
        List<String> completed = new ArrayList<>();
        autoComplete(last, prefix, completed);
        return completed;
    }

    private void autoComplete(Node node, String word, List<String> words) {
        if (node == null)
            return;
        if (node.isLastChar) {
            words.add(word);
        }

        for (Node current : node.getChildren()) {
            autoComplete(current, word + current.value, words);
            // we can only add the current char to the word inside the recursive call
            // if we add it outside the call we will ger a wrong result because of the for loop
        }
    }

    private Node lastNode(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            Node child = current.getChild(c);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }
}