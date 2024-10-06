package graph;

public class VisitGraphNodes {

    public static void main(String[] args) {
        Graph graph = new Graph();

        var vertexA = new Vertex("A");

        graph.addVertex(vertexA);
        graph.addVertex(new Vertex("B"));
        graph.addVertex(new Vertex("C"));
        graph.addVertex(new Vertex("D"));
        graph.addVertex(new Vertex("E"));
        graph.addVertex(new Vertex("F"));

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");
        graph.addEdge("A", "F");

        GraphUntil graphUntil = new GraphUntil();
        graphUntil.dfsIterative(graph, vertexA);
    }
}
