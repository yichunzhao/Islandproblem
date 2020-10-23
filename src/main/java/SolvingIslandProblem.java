import model.Grid;
import solver.AbstractSolver;
import solver.IslandSolver;
import solver.Result;

import java.util.Arrays;
import java.util.List;

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

        AbstractSolver<Integer> solver = new IslandSolver<>(grid);
        Result<List<IslandSolver.Island>> listResult = solver.solve();


        System.out.println(Arrays.deepToString(matrix));

    }
}
