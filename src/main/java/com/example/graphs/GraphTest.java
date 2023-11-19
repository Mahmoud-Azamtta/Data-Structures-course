package com.example.graphs;

public class GraphTest {
    public static void main(String[] args) {
        MapGraph graph = new MapGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "A");

        System.out.println(graph.hasCycle());
    }
}
