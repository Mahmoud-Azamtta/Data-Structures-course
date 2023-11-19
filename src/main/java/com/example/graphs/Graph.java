package com.example.graphs;

import java.util.*;

public class Graph {
    private static class Node {
         String label;
         List<Node> adjacent;
         Node (String label) {
             this.label = label;
             this.adjacent = new LinkedList<>();
         }
    }

    private final List<Node> adjacencyList;

    public Graph() {
        this.adjacencyList = new ArrayList<>();
    }

    public void addNode(String label) {
        if (containsVertex(label)) {
            System.out.println("node already exists");
            return;
        }
        adjacencyList.add(new Node(label));
    }

    public void removeNode(String label) {
        if (!containsVertex(label)) {
            System.out.println("node does not exist");
            return;
        }
        Iterator<Node> adjacencyListIterator = adjacencyList.iterator();
        while (adjacencyListIterator.hasNext()) {
            Node node = adjacencyListIterator.next();
            if (node.label.equals(label)) {
                adjacencyListIterator.remove();
                continue;
            }
            Iterator<Node> adjacentNodesIterator = node.adjacent.iterator();
            while (adjacentNodesIterator.hasNext()) {
                Node adjacentNode = adjacentNodesIterator.next();
                if (adjacentNode.label.equals(label))
                    adjacentNodesIterator.remove();
            }
        }
    }

    public void addEdge(String from, String to) {
        if (!containsVertex(from))
            addNode(from);
        if (!containsVertex(to))
            addNode(to);
        Node fromNode = getNode(from);
        Node toNode = new Node(to);
        assert fromNode != null;
        if (fromNode.adjacent.contains(toNode)) {
            System.out.println("node already adjacent to each other");
            return;
        }
        fromNode.adjacent.add(toNode);
    }

    public void removeEdge(String from, String to) {
        if (!containsVertex(from) || !containsVertex(to))
            return;
        Node fromNode = getNode(from);
        assert fromNode != null;
        for (Node node : fromNode.adjacent) {
            if (node.label.equals(to))
                fromNode.adjacent.remove(node);
        }
    }

    public void print() {
        for (Node node : adjacencyList) {
            System.out.print(node.label + ": ");
            for (Node adjacentNode : node.adjacent)
                System.out.print(adjacentNode.label + " ");
            System.out.println();
        }
    }

    private boolean containsVertex(String label) {
        for (Node node : adjacencyList) {
            if (node.label.equals(label))
                return true;
        }
        return false;
    }

    private Node getNode(String label) {
        for (Node node : adjacencyList) {
            if (node.label.equals(label))
                return node;
        }
        return null;
    }
}
