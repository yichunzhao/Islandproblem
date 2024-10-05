package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {

    @Test
    void addVertex_addsVertexToGraph() {
        Graph graph = new Graph();
        graph.addVertex(new Vertex("A"));
        assertTrue(graph.getVertices().containsKey("A"));
    }

    @Test
    void addEdge_addsEdgeBetweenExistingVertices() {
        Graph graph = new Graph();
        graph.addVertex(new Vertex("A"));
        graph.addVertex(new Vertex("B"));
        graph.addEdge("A", "B");
        assertTrue(graph.getVertex("A").getAdjacentVertexes().contains(graph.getVertex("B").getLabel()));
        assertTrue(graph.getVertex("B").getAdjacentVertexes().contains(graph.getVertex("A").getLabel()));
    }

    @Test
    void addEdge_throwsExceptionWhenSourceVertexNotFound() {
        Graph graph = new Graph();
        graph.addVertex(new Vertex("A"));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B"));
    }

    @Test
    void addEdge_throwsExceptionWhenTargetVertexNotFound() {
        Graph graph = new Graph();
        graph.addVertex(new Vertex("A"));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B"));
    }

    @Test
    void addEdge_throwsExceptionWhenBothVerticesNotFound() {
        Graph graph = new Graph();
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B"));
    }
}