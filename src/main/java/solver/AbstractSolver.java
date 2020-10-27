package solver;


import lombok.Getter;
import model.Grid;

public abstract class AbstractSolver<E> {
    @Getter
    protected boolean[][] visited;
    @Getter
    protected Grid<E> grid;

    //max row number
    private int mr;
    //min col number
    private int mc;

    public AbstractSolver(Grid<E> grid) {
        this.grid = grid;
        this.mr = grid.maxRow();
        this.mc = grid.maxCol();
        this.visited = new boolean[mr][mc];
    }

    public abstract Result solve();

    protected boolean isVisited(Grid.Coordinate coordinate) {
        checkMatrixBound(coordinate);
        return visited[coordinate.row()][coordinate.col()];
    }

    protected void markAsVisited(Grid.Coordinate coordinate) {
        checkMatrixBound(coordinate);
        this.visited[coordinate.row()][coordinate.col()] = true;
    }

    private void checkMatrixBound(Grid.Coordinate coordinate) {
        if (coordinate.row() > mr - 1 || coordinate.col() > mc - 1)
            throw new IllegalArgumentException("coordinate is out of matrix bound");
    }
}


