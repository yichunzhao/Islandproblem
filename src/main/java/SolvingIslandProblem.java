import java.util.Arrays;

public class SolvingIslandProblem {
    private final static int[][] matrix = {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
    };

    public static void main(String[] args) {

        //transform matrix into a graph


        System.out.println(Arrays.deepToString(matrix));

    }
}
