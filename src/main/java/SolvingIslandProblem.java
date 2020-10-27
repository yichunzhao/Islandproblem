import model.Grid;
import solver.IslandSolver;
import solver.Result;

import java.util.Arrays;

public class SolvingIslandProblem {
    private final static Integer[][] matrix = {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
    };

    public static void main(String[] args) {
        Grid<Integer> grid = new Grid<>(matrix);
        System.out.println(Arrays.deepToString(matrix));

        IslandSolver<Integer> solver = new IslandSolver<>(grid);


        Result r = solver.solve();
        boolean[][] visited = (boolean[][]) r.get(Result.Key.Visited);
        System.out.println(Arrays.deepToString(visited));

    }
}
