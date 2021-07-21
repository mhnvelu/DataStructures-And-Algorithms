package com.dsa.graph;

import java.util.*;

public class Graph<T> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacentVertices = new HashMap<>();

    public Graph() {

    }

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

    void addEdge(T value_1, T value_2) {
        Vertex v1 = new Vertex<T>(value_1);
        Vertex v2 = new Vertex<T>(value_2);
        adjacentVertices.get(v1).add(v2);
    }

    void addVertex(T value) {
        adjacentVertices.put(new Vertex<T>(value), new ArrayList<Vertex<T>>());
    }


    public void printGraph() {
        for (Map.Entry<Vertex<T>, List<Vertex<T>>> vertex : adjacentVertices.entrySet()) {
            System.out.println("Adjacency List of " + vertex.getKey().getValue() + " : ");
            StringBuilder builder = new StringBuilder();
            for (Vertex adjacent : vertex.getValue()) {
                builder.append("-->" + adjacent.getValue());

            }
            System.out.println(builder.toString());
        }
    }

    List<Vertex<T>> getAdjacentVertices(T value) {
        return adjacentVertices.get(new Vertex<T>(value));
    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public Set<Vertex<T>> getVertices() {
        return adjacentVertices.keySet();
    }

}
