package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VertexTest {

    @Test
    void of_createsVertexWithLabelAndEmptyAdjacentVertexes() {
        Vertex vertex = new Vertex("A");
        assertEquals("A", vertex.getLabel());
        assertTrue(vertex.getAdjacentVertexes().isEmpty());
    }

    @Test
    void addAdjacentVertex_addsVertexToAdjacentVertexes() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        vertexA.addAdjacentVertex(vertexB);
        assertTrue(vertexA.getAdjacentVertexes().contains(vertexB));
    }

    @Test
    void addAdjacentVertex_doesNotAddDuplicateVertex() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");

        vertexA.addAdjacentVertex(vertexA);
        vertexB.addAdjacentVertex(vertexB);

        assertEquals(1, vertexA.getAdjacentVertexes().size());
        assertEquals(1, vertexB.getAdjacentVertexes().size());
    }
}