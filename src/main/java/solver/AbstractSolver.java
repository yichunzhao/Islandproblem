package solver;


import model.Grid;

public abstract class AbstractSolver<T> {

    protected Grid<T> grid;

    public AbstractSolver(Grid<T> grid) {
        this.grid = grid;
    }

    public abstract <R> Result<R> solve();
}


