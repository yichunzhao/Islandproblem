package model;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class GridTest {

    private final Integer[][] matrix = {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
    };

    @Test
    @DisplayName("calculate adjacent coordinates around r=0,c=0")
    public void whenInputCoordinate00_thenReturnTwoAdjacent() {
        Set<Grid.Dir> expected = Stream.of(Grid.Dir.right, Grid.Dir.down).collect(toSet());
        Set<Grid.Dir> notExpected = Stream.of(Grid.Dir.up, Grid.Dir.left).collect(toSet());

        Grid<Integer> grid = new Grid<>(matrix);
        Map<Grid.Dir, Grid.Coordinate> map = grid.adjacentTo(0, 0);
        assertThat(map, is(notNullValue()));

        assertAll(
                () -> assertThat(map.size(), is(2)),
                () -> assertThat(map.keySet().containsAll(expected), is(true)),
                () -> assertThat(map.keySet().containsAll(notExpected), is(false))
        );

        log.info(map.toString());
    }

    @Test
    @DisplayName("calculate adjacent coordinates around r=2,c=2")
    void whenInputCoordinate22_ThenReturn4Adjacent() {
        Grid<Integer> grid = new Grid<>(matrix);
        Map<Grid.Dir, Grid.Coordinate> map = grid.adjacentTo(2, 2);
        assertAll(
                () -> assertThat(map, is(notNullValue())),
                () -> assertThat(map.keySet().containsAll(Arrays.asList(Grid.Dir.values())), is(true)),
                () -> assertThat(map.get(Grid.Dir.up), is(Grid.Coordinate.of(1, 2))),
                () -> assertThat(map.get(Grid.Dir.down), is(Grid.Coordinate.of(3, 2))),
                () -> assertThat(map.get(Grid.Dir.left), is(Grid.Coordinate.of(2, 1))),
                () -> assertThat(map.get(Grid.Dir.right), is(Grid.Coordinate.of(2, 3)))
        );
    }

    @Test
    void gridMaxRowAndMaxCol_ConsistentWithInputMatrix() {
        Grid<Integer> grid = new Grid<>(matrix);
        assertThat(grid.maxCol(), is(matrix[1].length));
        assertThat(grid.maxRow(), is(matrix.length));
    }

    @Test
    @DisplayName("when matrix row having different length, throw exception")
    void whenInputRowsHavingDifferentLengths_ThenGetException() {
        final Integer[][] matrix = {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Grid<>(matrix);
        });

        assertThat(exception.getMessage(), is("rows should have the same length"));
    }

    @Test
    void givenRowCol_getElementValue() {
        Grid<Integer> grid = new Grid<>(matrix);
        int x23 = grid.value(2, 3);
        int x00 = grid.value(0, 0);
        int x65 = grid.value(grid.maxRow()-1, grid.maxCol()-1);

        assertAll(
                () -> assertThat(x23, is(0)),
                () -> assertThat(x00, is(1)),
                () -> assertThat(x00, is(1))
        );
    }

    @Test
    void givenRowColOutOfBoundary_ThenGetException() {
        Grid<Integer> grid = new Grid<>(matrix);
        assertThrows(IllegalArgumentException.class, () -> grid.value(7, 7));
    }
}