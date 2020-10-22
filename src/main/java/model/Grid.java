package model;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A Grid, contains cells, which is located ref. its Coordinate in the matrix.
 * <p>
 * assuming a grid cell connects a left, a right, a up and a down cell respectively.
 * <p>
 * assuming standing at a cell, coordinate(col,row)
 * <p>
 * directional vectors
 * left: (0,-1), right:(0,1), up:(-1,0), down:(1,0)
 */

@EqualsAndHashCode
public class Grid<T> {

    private static final Map<String, int[]> dv = new HashMap<>();

    static {
        dv.put("left", new int[]{0, -1});
        dv.put("right", new int[]{0, 1});
        dv.put("up", new int[]{-1, 0});
        dv.put("down", new int[]{1, 0});
    }

    private int maxRow;
    private int maxCol;

    private T[][] elements;

    public Grid(T[][] elements) {
        if (!rowsHavingSameLength(elements))
            throw new IllegalArgumentException("rows should have the same length");
        this.elements = elements;
        maxRow = elements.length;
        maxCol = elements[1].length;
    }

    private boolean rowsHavingSameLength(T[][] elements) {
        return Arrays.stream(elements).map(ts -> ts.length).distinct().count() == 1;
    }

    @RequiredArgsConstructor(staticName = "of")
    public static class Coordinate {
        final int rowIndex;
        final int colIndex;
    }

    @RequiredArgsConstructor(staticName = "of")
    public static class Cell<T> {
        final T content;
        final Coordinate coordinate;
    }

    public Map<String, Coordinate> adjacentTo(int r, int c) {
        Map<String, Coordinate> neighbors = new HashMap();

        for (Map.Entry<String, int[]> e : dv.entrySet()) {
            int[] d = e.getValue();
            if (r + d[0] > maxRow || r + d[0] < 0) continue;
            if (c + d[1] > maxCol || c + d[1] < 0) continue;

            int nr = r + d[0];
            int nc = c + d[1];

            neighbors.put(e.getKey(), new Coordinate(nr, nc));
        }

        return neighbors;
    }

}


