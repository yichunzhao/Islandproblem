package solver;

import model.Grid;
import org.junit.jupiter.api.Test;

class IslandSolverTest {
    private final Short[][] matrix = {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
    };

    private Grid<Short> grid = new Grid<>(matrix);

    @Test
    void solve() {

        AbstractSolver solver = new IslandSolver<>(grid);


        solver.solve();
    }
}