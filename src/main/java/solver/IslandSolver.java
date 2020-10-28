package solver;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.Grid;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class IslandSolver<E> extends AbstractSolver<E> {

    protected Queue<Grid.Coordinate> queue;
    protected Deque<Grid.Cell<E>> stack;

    public IslandSolver(Grid<E> grid) {
        super(grid);

        this.queue = new LinkedList<>();
        this.stack = new LinkedList<>();
    }

    @Data(staticConstructor = "create")
    public static class Island<E> {
        List<E> lands = new ArrayList<>();

        public void addLand(E e) {
            lands.add(e);
        }
    }

    @Override
    public Result solve(Grid.Coordinate source) {
        Result result = Result.create();
        List<Island> islands = new ArrayList<>();

        //put source in the Q, and keep it until all its neighbors found.
        queue.offer(source);
        markAsVisited(source);

        while (!queue.isEmpty()) {
            log.info(this.queue.toString());

            //deQueue v from the queue
            Grid.Coordinate v = queue.poll();

            Grid.Cell<E> cell = Grid.Cell.of(grid.value(v), v);
            if (grid.value(v).equals(1)) {
                stack.push(cell);
            }

            //Finding out all its surrounding cells
            //If it is not-visited yet, enQueue it.
            grid.adjacentTo(v).stream()
                    .filter(n -> !isVisited(n))
                    .forEach(nv -> {
                        queue.offer(nv);
                        markAsVisited(nv);
                    });
        }

        result.addResult(Result.Key.Visited, visited);
        result.addResult(Result.Key.Cell, stack);

        return result;
    }


}
