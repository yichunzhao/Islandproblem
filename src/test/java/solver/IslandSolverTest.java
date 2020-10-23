package solver;

import model.Grid;
import org.junit.jupiter.api.Test;

class IslandSolverTest {
    private final Integer[][] matrix = {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
    };

    private Grid<Integer> grid = new Grid<>(matrix);

    @Test
    void solve() {
        AbstractSolver<Integer> solver = new IslandSolver<>(grid);


        solver.solve();
    }
}