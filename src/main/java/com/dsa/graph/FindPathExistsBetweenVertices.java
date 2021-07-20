package com.dsa.graph;

import com.dsa.queue.MyQueue;

import java.util.HashSet;
import java.util.Set;

/*
Problem Description: Find if a path exists between given vertices in a directed graph.
 */

/*
Solution:
Use BFS

Path exists between 1 and 5: true
Path exists between 3 and 5: false
 */

public class FindPathExistsBetweenVertices {
    public static void main(String a[]) {
        FindPathExistsBetweenVertices obj = new FindPathExistsBetweenVertices();
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 5);
        graph.addEdge(4, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.printGraph();

        int vertex_1 = 3;
        int vertex_2 = 5;
        boolean result = obj.isPathExistBetweenVertices(graph, vertex_1, vertex_2);
        System.out.println("Path exists between " + vertex_1 + " and " + vertex_2 + ": " + result);
    }


    boolean isPathExistBetweenVertices(Graph graph, int vertex_1, int vertex_2) {
        Vertex node_1 = new Vertex(vertex_1);
        Vertex node_2 = new Vertex(vertex_2);

        Set<Vertex> visited = new HashSet<>();

        MyQueue<Vertex> queue = new MyQueue<>();

        queue.add(node_1);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            for (Vertex adjacent : graph.getAdjacentVertices(vertex.getValue())) {
                if (node_2.getValue() == adjacent.getValue()) {
                    return true;
                } else {
                    if (!visited.contains(adjacent)) {
                        queue.add(adjacent);
                    }
                }
            }
            visited.add(vertex);
        }
        return false;
    }
}
