package graph;

public class VisitGraphNodesByBFS extends AbstractGraphTest {

    public static void main(String[] args) {
        var graph = createGraph();
        var vertexA = graph.getVertex("A");

        System.out.println("BFS:");
        GraphUntil graphUntil = new GraphUntil();
        graphUntil.bfsIterative(graph, vertexA);
    }
}
