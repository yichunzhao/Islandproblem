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

    /**
     * adding a vertex to the graph.
     *
     * @param label the label of the vertex.
     *              return the graph.
     */
    public void addVertex(String label) {
        vertices.put(label, new Vertex(label));
    }

    /**
     * getting the vertices of the graph.
     * <p>
     * return the vertices of the graph.
     */
    public Map<String, Vertex> getVertices() {
        return vertices;
    }

    public void printGraph() {
        for (Map.Entry<String, Vertex> entry : vertices.entrySet()) {
            System.out.println("Vertex: " + entry.getKey());

            entry.getValue().getAdjacentVertexes()
                    .forEach(vertex -> System.out.println(" -> " + vertex.getLabel()));
        }
    }
}
