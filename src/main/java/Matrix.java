import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Matrix {

    private int m;  //row
    private int n;  //col.

    @Getter
    private int[][] matrix;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        matrix = new int[m][n];
    }

    public Matrix(int[][] data) {
        this.m = matrix.length;
        this.n = data[0].length;

        this.matrix = matrix;
    }
}
