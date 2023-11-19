package com.example.graphs;

import java.util.*;
public class MapGraph {
    private static class Node {
        String label;
        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private final Map<String, Node> nodes;
    private final Map<Node, List<Node>> adjacencyList;

    public MapGraph() {
        this.nodes = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("the from node does not exist");
        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("the to node does not exist");
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            return;
        for (Node n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);
        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDF(String label) {
        if (nodes.isEmpty() || !nodes.containsKey(label))
            return;
        traverseDF(nodes.get(label) ,new HashSet<>());
        System.out.println();
    }

    private void traverseDF(Node node, Set<Node> set) {
        if (set.contains(node))
            return;
        System.out.print(node.label + " ");
        set.add(node);
        for (Node n : adjacencyList.get(node))
            traverseDF(n, set);
    }

    public void iterativeTraverseDF(String label) {
        if (nodes.isEmpty() || !nodes.containsKey(label))
            return;
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(nodes.get(label));
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (set.contains(current))
                continue;
            System.out.println(current);
            set.add(current);
            for (Node n : adjacencyList.get(current))
                stack.push(n);
        }
    }

    public void BFS(String label) {
        if (nodes.isEmpty() || !nodes.containsKey(label))
            return;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(nodes.get(label));
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (set.contains(current))
                continue;
            System.out.print(current + " ");
            set.add(current);
            for (Node n : adjacencyList.get(current))
                queue.add(n);
        }
    }

    public List<String> topologicalSort(String label) {
        if (nodes.isEmpty())
            return null;
        Stack<String> stack = new Stack<>();
        List<String> sorted = new ArrayList<>();
        topologicalSort(nodes.get(label), stack, new HashSet<>());
        while (!stack.empty())
            sorted.add(stack.pop());
        return sorted;
    }

    private void topologicalSort(Node node, Stack<String> stack, Set<Node> visited) {
        if (visited.contains(node))
            return;
        visited.add(node);
        for (Node n : adjacencyList.get(node))
            topologicalSort(n, stack, visited);
        stack.push(node.label);
    }

    public boolean hasCycle() {
        if (nodes.isEmpty())
            return false;
        Set<Node> white = new HashSet<>(nodes.values());
        Set<Node> gray = new HashSet<>();
        Set<Node> black = new HashSet<>();
        for (Node node : white) {
            if (hasCycle(node, white, gray, black))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> white, Set<Node> gray, Set<Node> black) {
        white.remove(node);
        gray.add(node);
        for (Node n : adjacencyList.get(node)) {
            if (black.contains(n))
                continue;
            if (gray.contains(n) || hasCycle(n, white, gray, black))
                return true;
        }
        gray.remove(node);
        black.add(node);
        return false;
    }

    public void print() {
        for (String label : nodes.keySet()) {
            Node node = nodes.get(label);
            System.out.println(label + "->" + adjacencyList.get(node));
        }
    }
}