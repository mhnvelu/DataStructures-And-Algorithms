package com.dsa.graph;

import java.util.List;
import java.util.Set;

public class DFS {
    public static void main(String a[]) {
        Graph<Integer> graph = new Graph<Integer>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.printGraph();

        DFS dfs = new DFS();
        dfs.dfs(graph);

    }

    public void dfs(Graph graph) {
        Vertex<Integer> sourceVertex = new Vertex(1);
        Set<Vertex<Integer>> vertices = graph.getVertices();
        boolean visited[] = new boolean[vertices.size()];
        dfsVisit(graph, sourceVertex, visited);
    }

    public void dfsVisit(Graph graph, Vertex<Integer> sourceVertex, boolean visited[]) {
        System.out.println(sourceVertex.getValue() + " ");
        visited[sourceVertex.getValue()] = true;
        List<Vertex<Integer>> vertices = graph.getAdjacentVertices(sourceVertex.getValue());
        for (Vertex<Integer> adj :
                vertices) {
            if (!visited[adj.getValue()]) {
                dfsVisit(graph, adj, visited);
            }
        }
    }
}
