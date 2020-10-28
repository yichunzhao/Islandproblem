package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class Grid<E> {

    private static final Map<Dir, int[]> dv = new HashMap<>();

    static {
        dv.put(Dir.left, new int[]{0, -1});
        dv.put(Dir.right, new int[]{0, 1});
        dv.put(Dir.up, new int[]{-1, 0});
        dv.put(Dir.down, new int[]{1, 0});
    }

    public enum Dir {left, right, up, down}

    private final int maxRow;
    private final int maxCol;

    private final E[][] elements;

    public Grid(E[][] elements) {
        if (!rowsHavingSameLength(elements))
            throw new IllegalArgumentException("rows should have the same length");
        this.elements = elements;
        maxRow = elements.length;
        maxCol = elements[1].length;
    }

    private boolean rowsHavingSameLength(final E[][] elements) {
        return Arrays.stream(elements).map(ts -> ts.length).distinct().count() == 1;
    }

    @RequiredArgsConstructor(staticName = "of")
    @ToString
    @EqualsAndHashCode
    public static class Coordinate {
        final int row;
        final int col;

        public Coordinate(int[] r_c) {
            this.row = r_c[0];
            this.col = r_c[1];
        }

        public int row() {
            return row;
        }

        public int col() {
            return col;
        }
    }

    @RequiredArgsConstructor(staticName = "of")
    @ToString
    @Getter
    public static class Cell<T> {
        final T content;
        final Coordinate coordinate;
    }

    public Map<Dir, Coordinate> adjacentTo(int r, int c) {
        Map<Dir, Coordinate> neighbors = new HashMap();

        for (Map.Entry<Dir, int[]> e : dv.entrySet()) {
            int[] d = e.getValue();
            if (r + d[0] > maxRow - 1 || r + d[0] < 0) continue;
            if (c + d[1] > maxCol - 1 || c + d[1] < 0) continue;

            int nr = r + d[0];
            int nc = c + d[1];

            neighbors.put(e.getKey(), new Coordinate(nr, nc));
        }

        return neighbors;
    }

    public Set<Coordinate> adjacentTo(Coordinate co) {
        return new HashSet<>(adjacentTo(co.row, co.col).values());
    }

    public E value(int r, int c) {
        if (r > maxRow || r < 0) throw new IllegalArgumentException("row index > rowMax");
        if (c > maxCol || c < 0) throw new IllegalArgumentException("row index > rowMax");

        return elements[r][c];
    }

    public E value(Coordinate coordinate){
        return value(coordinate.row,coordinate.col);
    }

    public int maxRow() {
        return this.maxRow;
    }

    public int maxCol() {
        return this.maxCol;
    }

}


