package graph;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Vertex, a node in a graph.
 */
@Getter
@Setter
public class Vertex {
    private final String label;
    private final Set<Vertex> adjacentVertexes;

    public Vertex(String label) {
        this.label = label;
        adjacentVertexes = new HashSet<>();
    }

    public void addAdjacentVertex(Vertex vertex) {
        adjacentVertexes.add(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex vertex)) return false;
        return Objects.equals(label, vertex.label) && Objects.equals(adjacentVertexes, vertex.adjacentVertexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
