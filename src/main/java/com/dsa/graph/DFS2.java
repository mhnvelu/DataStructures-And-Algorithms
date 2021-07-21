package com.dsa.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS2 {

    static HashMap<Vertex<Integer>, Vertex<Integer>> parents = new HashMap<>();

    public static void main(String a[]) {
        Graph<Integer> graph = new Graph<Integer>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);


        graph.addEdge(6, 7);

        graph.printGraph();

        DFS2 dfs = new DFS2();
        dfs.dfs(graph);

        System.out.println("Print Parent-Child nodes of the graph");
        for (Map.Entry<Vertex<Integer>, Vertex<Integer>> entry : parents.entrySet()) {
            System.out.println(entry.getKey().getValue() + " " + entry.getValue());
        }

        // find the clusters in the graph. If any key in parents map has value null, then it represents a cluster
        for (Map.Entry<Vertex<Integer>, Vertex<Integer>> entry : parents.entrySet()) {
            if(entry.getValue() == null){
                System.out.println("Cluster Found with Parent Node as : " + entry.getKey().getValue());
            }
        }
    }

    public void dfs(Graph graph) {
        Set<Vertex<Integer>> vertices = graph.getVertices();

        boolean visited[] = new boolean[vertices.size()];
        for (Vertex<Integer> vertex : vertices
        ) {
            if (!parents.containsKey(vertex)) {
                parents.put(vertex, null);
                dfsVisit(graph, vertex, visited);
            }
        }
    }

    public void dfsVisit(Graph graph, Vertex<Integer> sourceVertex, boolean visited[]) {

        visited[sourceVertex.getValue()] = true;
        List<Vertex<Integer>> vertices = graph.getAdjacentVertices(sourceVertex.getValue());
        for (Vertex<Integer> vertex :
                vertices) {
            if (!parents.containsKey(vertex)) {
                parents.put(vertex, sourceVertex);
                dfsVisit(graph, vertex, visited);
            }
        }
        System.out.print(sourceVertex.getValue() + " " + "->");
    }
}
