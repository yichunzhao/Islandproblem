package util;

import org.junit.jupiter.api.Test;

class MatrixHelperTest {




    @Test
    void printIntegerMatrixIn2D() {
        Integer[][] matrix = {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };

        System.out.println(MatrixHelper.to2DString(matrix));
    }

    @Test
    void printShortMatrixIn2D() {
        Short[][] matrix = {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };

        System.out.println(MatrixHelper.to2DString(matrix));
    }

    @Test
    void printBooleanMatrixIn2D() {
        Boolean[][] matrix = {
                {true , false, false, false, false},
                {false, false, true , true , false},
        };

        System.out.println(MatrixHelper.to2DString(matrix));
    }

    @Test
    void printPrimitiveBooleanMatrixIn2D(){
        boolean[][] matrix = {
                {true , false, false, false, false},
                {false, false, true , true , false},
        };
        System.out.println(MatrixHelper.to2DString(matrix));

    }

    @Test
    void printIntegerMatrix() {
        Integer[][] matrix = {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };

        MatrixHelper.print(matrix);
    }

    @Test
    void printIntPrimitiveMatrix() {
        int[][] matrix = {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };

        MatrixHelper.print(matrix);
    }
}