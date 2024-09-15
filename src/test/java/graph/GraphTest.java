package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {

    @Test
    void addVertex_addsVertexToGraph() {
        Graph graph = new Graph();
        graph.addVertex("A");
        assertTrue(graph.getVertices().containsKey("A"));
    }

    @Test
    void addEdge_addsEdgeBetweenExistingVertices() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        assertTrue(graph.getVertices().get("A").getAdjacentVertexes().contains(graph.getVertices().get("B")));
        assertTrue(graph.getVertices().get("B").getAdjacentVertexes().contains(graph.getVertices().get("A")));
    }

    @Test
    void addEdge_throwsExceptionWhenSourceVertexNotFound() {
        Graph graph = new Graph();
        graph.addVertex("B");
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B"));
    }

    @Test
    void addEdge_throwsExceptionWhenTargetVertexNotFound() {
        Graph graph = new Graph();
        graph.addVertex("A");
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B"));
    }

    @Test
    void addEdge_throwsExceptionWhenBothVerticesNotFound() {
        Graph graph = new Graph();
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B"));
    }
}