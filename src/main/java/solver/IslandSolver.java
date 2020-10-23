package solver;


import model.Grid;

import java.util.ArrayList;
import java.util.List;


public class IslandSolver<E> extends AbstractSolver<E> {
    public class Island<E> {
        List<E> lands;
    }

    public IslandSolver(Grid<E> grid) {
        super(grid);
    }

    @Override
    public Result<List<Island>> solve() {
        List<Island> islands = new ArrayList<>();

        grid.adjacentTo(2,3);

        grid.value(1,2);

        return Result.of(islands);
    }
}
