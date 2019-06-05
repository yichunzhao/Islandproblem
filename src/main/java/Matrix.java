import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Matrix {

    @Getter
    private int rowNum;  //row
    @Getter
    private int colNum;  //col.

    @Getter
    private int[][] matrix;

    public Matrix(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        matrix = new int[rowNum][colNum];
    }

    public Matrix(int[][] data) {
        this.rowNum = data.length;
        this.colNum = data[0].length;

        this.matrix = data;
    }

    public int getValue(int x, int y) {
        if (x > rowNum || y > colNum) throw new IllegalArgumentException("out of boundary");

        return matrix[x][y];

    }


}
