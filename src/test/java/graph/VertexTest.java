package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        assertTrue(vertexA.hasAdjacentVertex(vertexB));
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

    @Test
    void addAdjacentVertexes_addsMultipleVertices() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        vertexA.addAdjacentVertexes(List.of(vertexB, vertexC));
        assertTrue(vertexA.hasAdjacentVertex(vertexB));
        assertTrue(vertexA.hasAdjacentVertex(vertexC));
    }

    @Test
    void addAdjacentVertexes_throwsExceptionWhenNull() {
        Vertex vertexA = new Vertex("A");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> vertexA.addAdjacentVertexes(null));

        assertEquals("vertexes cannot be null", exception.getMessage());
    }
}