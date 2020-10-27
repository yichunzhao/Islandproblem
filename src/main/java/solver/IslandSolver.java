package solver;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.Grid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Slf4j
public class IslandSolver<E> extends AbstractSolver {
    @Getter
    protected Grid<E> grid;

    @Getter
    protected boolean[][] visited;

    protected Queue<Grid.Coordinate> queue;

    protected int mr;
    protected int mc;

    public IslandSolver(Grid<E> grid) {
        super();
        this.grid = grid;
        this.visited = new boolean[grid.maxRow()][grid.maxCol()];
        this.queue = new LinkedList<>();
        this.mr = grid.maxRow();
        this.mc = grid.maxCol();
    }

    public class Island<E> {
        List<E> lands = new ArrayList<>();
    }

    @Override
    public Result solve() {
        Result result = Result.create();
        List<Island> islands = new ArrayList<>();

        //starting point, and put it in the Q
        Grid.Coordinate source = Grid.Coordinate.of(0, 0);
        //put it in the Q, and keep it until all its neighbors found.
        queue.offer(source);

        while (!queue.isEmpty()) {
            //deQ v from the queue
            Grid.Coordinate v = queue.poll();

            //finding out his surrounding cells
            Set<Grid.Coordinate> neighbors = grid.adjacentTo(v).entrySet().stream()
                    .map(Map.Entry::getValue).collect(toSet());

            //if a cell is not-visited(nv) yet, enQ it.
            neighbors.stream()
                    .filter(n -> !isVisited(n))
                    .forEach(nv -> queue.offer(nv));

            //mark current cell as visited.
            markAsVisited(v);
        }

        result.addResult(Result.Key.Visited, visited);

        return result;
    }

    private boolean isVisited(Grid.Coordinate coordinate) {
        checkMatrixBound(coordinate);
        return visited[coordinate.row()][coordinate.col()];
    }

    private void markAsVisited(Grid.Coordinate coordinate) {
        checkMatrixBound(coordinate);
        this.visited[coordinate.row()][coordinate.col()] = true;
    }

    private void checkMatrixBound(Grid.Coordinate coordinate) {
        if (coordinate.row() > grid.maxRow() - 1 || coordinate.col() > grid.maxCol() - 1)
            throw new IllegalArgumentException("coordinate is out of matrix bound");
    }

}
