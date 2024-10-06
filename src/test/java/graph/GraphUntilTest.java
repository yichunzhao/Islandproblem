package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GraphUntilTest {
    @Test
    void dfsIterative_visitsAllVertices() {
        Graph graph = mock(Graph.class);
        Vertex startVertex = mock(Vertex.class);
        Vertex adjacentVertex = mock(Vertex.class);

        when(startVertex.getLabel()).thenReturn("A");
        when(startVertex.isVisited()).thenReturn(false);
        when(startVertex.getAdjacentVertexes()).thenReturn(List.of("B"));
        when(adjacentVertex.getLabel()).thenReturn("B");
        when(adjacentVertex.isVisited()).thenReturn(false);
        when(adjacentVertex.getAdjacentVertexes()).thenReturn(List.of());

        when(graph.getVertex("A")).thenReturn(startVertex);
        when(graph.getVertex("B")).thenReturn(adjacentVertex);
        when(adjacentVertex.getLabel()).thenReturn("B");
        when(adjacentVertex.isVisited()).thenReturn(false);
        when(adjacentVertex.getAdjacentVertexes()).thenReturn(List.of());

        when(graph.getVertex("A")).thenReturn(startVertex);
        when(graph.getVertex("B")).thenReturn(adjacentVertex);

        GraphUntil graphUntil = new GraphUntil();
        graphUntil.dfsIterative(graph, startVertex);

        verify(startVertex).setVisited(true);
        verify(adjacentVertex).setVisited(true);
    }

    @Test
    void dfsIterative_throwsExceptionForNonExistentStartVertex() {
        Graph graph = mock(Graph.class);
        Vertex startVertex = mock(Vertex.class);

        when(startVertex.getLabel()).thenReturn("A");
        when(graph.getVertex("A")).thenThrow(new IllegalArgumentException("startVertex not found"));

        GraphUntil graphUntil = new GraphUntil();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                graphUntil.dfsIterative(graph, startVertex)
        );

        assertEquals("startVertex not found", exception.getMessage());
    }

    @Test
    void dfsIterative_doesNotRevisitVisitedVertices() {
        Graph graph = mock(Graph.class);
        Vertex startVertex = mock(Vertex.class);
        Vertex adjacentVertex = mock(Vertex.class);

        when(startVertex.getLabel()).thenReturn("A");
        when(startVertex.isVisited()).thenReturn(false);
        when(startVertex.getAdjacentVertexes()).thenReturn(List.of("B"));
        when(adjacentVertex.getLabel()).thenReturn("B");
        when(adjacentVertex.isVisited()).thenReturn(false);
        when(adjacentVertex.getAdjacentVertexes()).thenReturn(List.of());

        when(graph.getVertex("A")).thenReturn(startVertex);
        when(graph.getVertex("B")).thenReturn(adjacentVertex);
        when(adjacentVertex.getLabel()).thenReturn("B");
        when(adjacentVertex.isVisited()).thenReturn(true);

        when(graph.getVertex("A")).thenReturn(startVertex);
        when(graph.getVertex("B")).thenReturn(adjacentVertex);

        GraphUntil graphUntil = new GraphUntil();
        graphUntil.dfsIterative(graph, startVertex);

        verify(startVertex).setVisited(true);
        verify(adjacentVertex, never()).setVisited(true);
    }
}