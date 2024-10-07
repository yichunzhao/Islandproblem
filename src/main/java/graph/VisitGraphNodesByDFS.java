package graph;

public class VisitGraphNodesByDFS extends AbstractGraphTest {

    public static void main(String[] args) {
        var graph = createGraph();
        var vertexA = graph.getVertex("A");

        System.out.println("DFS:");
        GraphUntil graphUntil = new GraphUntil();
        graphUntil.dfsIterative(graph, vertexA);
    }
}
