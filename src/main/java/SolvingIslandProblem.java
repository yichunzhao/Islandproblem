import model.Grid;
import solver.AbstractSolver;
import solver.IslandSolver;
import solver.Result;
import util.MatrixHelper;

import java.util.Deque;

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
        System.out.println("grid matrix:");
        System.out.println(MatrixHelper.to2DString(matrix));

        AbstractSolver<Integer> solver = new IslandSolver<>(grid);

        Result r = solver.solve(Grid.Coordinate.of(0, 0));
        boolean[][] visited = (boolean[][]) r.get(Result.Key.Visited);

        Deque<Grid.Cell> deque = (Deque<Grid.Cell>) r.get(Result.Key.Cell);

        System.out.println("visited matrix:");
        System.out.println(MatrixHelper.to2DString(visited));

        //System.out.println("stack: " + deque.toString());

        deque.forEach(System.out::println);
        System.out.println("size of stack: " + deque.size());
    }
}
