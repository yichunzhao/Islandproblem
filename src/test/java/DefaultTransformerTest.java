import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DefaultTransformerTest {
    private Matrix matrix;

    @Before
    public void setup() {
        int[][] array = {{1, 2}, {3, 4}};
        matrix = new Matrix(array);
    }

    @Test
    public void testSketchGraph() {
        DefaultTransformer transformer = new DefaultTransformer();
        Graph<Vertex> sketchedGraph = transformer.sketchGraph(matrix);

        assertNotNull(sketchedGraph);
        int expectedNum = matrix.getColNum() * matrix.getRowNum();
        assertThat(sketchedGraph.getVertices().size(), is(expectedNum));
    }

}