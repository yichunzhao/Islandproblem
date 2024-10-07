package graph;

import lombok.extern.java.Log;

import java.util.ArrayDeque;
import java.util.Deque;

@Log
public class GraphUntil {

    /**
     * Performs a Depth First Search (DFS) on the given graph starting from the specified vertex.
     *
     * @param graph       the graph to perform DFS on
     * @param startVertex the starting vertex for the DFS
     * @throws IllegalArgumentException if the startVertex is not found in the graph
     *                                  This method logs the process of visiting each vertex. It marks the start vertex as visited,
     *                                  then uses a stack to explore each adjacent vertex. If an adjacent vertex has not been visited,
     *                                  it is marked as visited and its adjacent vertices are pushed onto the stack for further exploration.
     */
    public void dfsIterative(Graph graph, Vertex startVertex) {
        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }

        if (startVertex == null || graph.getVertex(startVertex.getLabel()) == null) {
            throw new IllegalArgumentException("startVertex not found in the graph");
        }

        log.info("Depth First Search (DFS) starting from: " + startVertex.getLabel());
        System.out.println("Visiting vertex: " + startVertex.getLabel());
        startVertex.setVisited(true);

        Deque<String> stack = new ArrayDeque<>();

        startVertex.getAdjacentVertexes().forEach(stack::push);

        // while the stack is not empty
        while (!stack.isEmpty()) {
            System.out.println("stack: " + stack);
            // get the next vertex
            String vertexLabel = stack.pop();
            Vertex vertex = graph.getVertex(vertexLabel);

            // if the vertex has not been visited
            if (!vertex.isVisited()) {
                // visit the vertex
                System.out.println("Visiting vertex: " + vertex.getLabel());
                vertex.setVisited(true);

                // get the adjacent vertexes of the vertex, push them to the stack one by one
                vertex.getAdjacentVertexes().forEach(av -> {
                    Vertex adjacentVertex = graph.getVertex(av);
                    if (!adjacentVertex.isVisited()) {
                        stack.push(adjacentVertex.getLabel());
                    }
                });
            }
        }
    }

    /**
     * Performs a Breadth First Search (BFS) on the given graph starting from the specified vertex.
     *
     * @param graph       the graph to perform BFS on
     * @param startVertex the starting vertex for the BFS
     * @throws IllegalArgumentException if the startVertex is not found in the graph
     *                                  This method logs the process of visiting each vertex. It marks the start vertex as visited,
     *                                  then uses a queue to explore each adjacent vertex. If an adjacent vertex has not been visited,
     *                                  it is marked as visited and its adjacent vertices are added to the queue for further exploration.
     */
    public void bfsIterative(Graph graph, Vertex startVertex) {
        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }

        if (startVertex == null || graph.getVertex(startVertex.getLabel()) == null) {
            throw new IllegalArgumentException("startVertex not found in the graph");
        }

        log.info("Breadth First Search (BFS) starting from: " + startVertex.getLabel());
        startVertex.setVisited(true);
        System.out.println("Visiting vertex: " + startVertex.getLabel());

        Deque<String> queue = new ArrayDeque<>();

        startVertex.getAdjacentVertexes().forEach(queue::offer);

        // while the queue is not empty
        while (!queue.isEmpty()) {
            System.out.println("queue: " + queue);
            // get the next vertex
            String vertexLabel = queue.poll();
            Vertex vertex = graph.getVertex(vertexLabel);

            // if the vertex has not been visited
            if (!vertex.isVisited()) {
                // visit the vertex
                System.out.println("Visiting vertex: " + vertex.getLabel());
                vertex.setVisited(true);

                // get the adjacent vertexes of the vertex, add them to the queue one by one
                vertex.getAdjacentVertexes().forEach(av -> {
                    Vertex adjacentVertex = graph.getVertex(av);
                    if (!adjacentVertex.isVisited()) {
                        queue.offer(adjacentVertex.getLabel());
                    }
                });
            }
        }
    }
}
