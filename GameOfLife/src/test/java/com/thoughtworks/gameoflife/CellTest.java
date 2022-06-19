package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.gameoflife.CellState.ALIVE;
import static com.thoughtworks.gameoflife.CellState.DEAD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CellTest {
    @Test
    void shouldReturnCellStateAsAliveWhenTheCellIsAlive() {
        Coordinate coordinate = new Coordinate(1, 1);
        Cell cell = Cell.createAliveCell(coordinate);

        CellState actualState = cell.getState();

        assertThat(actualState, is(ALIVE));
    }

    @Test
    void shouldReturnCellStateAsDeadWhenTheCellIsDead() {
        Coordinate coordinate = new Coordinate(1, 1);
        Cell cell = Cell.createDeadCell(coordinate);

        CellState actualState = cell.getState();

        assertThat(actualState, is(DEAD));
    }

}
