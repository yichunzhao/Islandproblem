package graph;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * A Graph, a collection of vertices and edges.
 * <p>
 * Graph is a collection of vertices and edges. It is a set of nodes where some pairs of the nodes are connected by edges.
 * <p>
 * directed graph: a graph in which the edges have a direction.
 */

@Getter
public class Graph {
    /**
     * A collection of vertices, a node in a graph.
     * <p>
     * a vertex has a unique label to identify it.
     * -- GETTER --
     * getting the vertices of the graph.
     * <p>
     * return the vertices of the graph.
     */
    private final Map<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    /**
     * adding an edge to the graph.
     *
     * @param source the label of the source vertex.
     * @param target the label of the target vertex.
     *               return the graph.
     */
    public void addEdge(String source, String target) {
        Vertex sourceVertex = vertices.get(source);
        Vertex targetVertex = vertices.get(target);

        if (sourceVertex == null || targetVertex == null) {
            throw new IllegalArgumentException("Vertex not found");
        }

        sourceVertex.addAdjacentVertex(targetVertex);
        targetVertex.addAdjacentVertex(sourceVertex);
    }

    public void addVertex(Vertex vertex) {
        vertices.putIfAbsent(vertex.getLabel(), vertex);
    }

    public Vertex getVertex(String label) {
        if (!vertices.containsKey(label)) {
            throw new IllegalArgumentException("Vertex not found");
        }
        return vertices.get(label);
    }

    public void printGraph() {
        for (Map.Entry<String, Vertex> entry : vertices.entrySet()) {
            System.out.println("Vertex: " + entry.getKey());

            entry.getValue().getAdjacentVertexes()
                    .forEach(label -> System.out.println(" -> " + label));
        }
    }
}
