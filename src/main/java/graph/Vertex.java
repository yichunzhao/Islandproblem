package graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * A Vertex, a node in a graph.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Vertex {

    private final String label;
    private final List<String> adjacentVertexes;

    public Vertex(String label) {
        if (label == null || label.isEmpty()) {
            throw new IllegalArgumentException("label cannot be null or empty");
        }
        this.label = label;
        adjacentVertexes = new ArrayList<>();
    }

    public void addAdjacentVertex(Vertex vertex) {
        adjacentVertexes.add(vertex.getLabel());
    }

    public void addAdjacentVertexes(List<Vertex> vertexes) {
        if (vertexes == null) {
            throw new IllegalArgumentException("vertexes cannot be null");
        }

        for (Vertex vertex : vertexes) {
            if (vertex == null) {
                throw new IllegalArgumentException("vertex cannot be null");
            }
        }

        adjacentVertexes.addAll(vertexes.stream().map(Vertex::getLabel).toList());
    }

    public boolean hasAdjacentVertex(Vertex vertex) {
        return adjacentVertexes.contains(vertex.getLabel());
    }
}
