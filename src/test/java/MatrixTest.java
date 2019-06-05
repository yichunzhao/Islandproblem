import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void createMatrixByDefiningRowAndCol() {
        int expectedRow = 2;
        int expectedCol = 3;
        Matrix matrix = new Matrix(expectedRow, expectedCol);
        assertNotNull(matrix.getMatrix());

        assertThat(matrix.getMatrix().length, is(expectedRow));
        assertThat(matrix.getMatrix()[0].length, is(expectedCol));
    }

    @Test
    public void createMatrixFromExisting2DArray(){
        int[][] xy = {{1, 2, 3}, {4, 5, 6}};

        Matrix matrix = new Matrix(xy);
        assertNotNull(matrix.getMatrix());
    }

}