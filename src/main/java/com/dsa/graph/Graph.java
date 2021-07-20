package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Vertex>> adjacentVertices = new HashMap<>();

    public static void main(String a[]) {
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

    }

    void addEdge(int value_1, int value_2) {
        Vertex v1 = new Vertex(value_1);
        Vertex v2 = new Vertex(value_2);
        adjacentVertices.get(v1).add(v2);
    }

    void addVertex(int value) {
        adjacentVertices.put(new Vertex(value), new ArrayList<Vertex>());
    }


    public void printGraph() {
        for (Map.Entry<Vertex, List<Vertex>> vertex : adjacentVertices.entrySet()) {
            System.out.println("Adjacency List of " + vertex.getKey().getValue() + " : ");
            StringBuilder builder = new StringBuilder();
            for (Vertex adjacent : vertex.getValue()) {
                builder.append("-->" + adjacent.getValue());

            }
            System.out.println(builder.toString());
        }
    }

    List<Vertex> getAdjacentVertices(int value) {
        return adjacentVertices.get(new Vertex(value));
    }

    public Map<Vertex, List<Vertex>> getAdjacentVertices() {
        return adjacentVertices;
    }

}
