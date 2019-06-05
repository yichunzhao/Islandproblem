import org.jetbrains.annotations.NotNull;

public class DefaultTransformer implements Transformer {


    @Override
    public DefaultGraph<Vertex> convert(Matrix matrix) {

        for (int i = 0; i < matrix.getRowNum() - 1; i++) {
            for (int j = 0; j < matrix.getColNum() - 1; j++) {


            }

        }

        return null;
    }

    public Graph sketchGraph(@NotNull Matrix matrix) {

        Graph<Vertex> graph = new DefaultGraph<>();

        for (int row = 0; row < matrix.getRowNum(); row++) {
            for (int col = 0; col < matrix.getColNum(); col++) {
                Vertex vertex = Vertex.builder().value(matrix.getValue(row, col))
                        .coordinate(Coordinate.builder().row(row).col(col).build())
                        .build();
                graph.addVertex(vertex);
            }
        }

        return graph;
    }

    private Vertex findUpperVertex(Matrix matrix, Coordinate current) {

        Vertex upperVertex = null;

        return upperVertex;
    }


}
