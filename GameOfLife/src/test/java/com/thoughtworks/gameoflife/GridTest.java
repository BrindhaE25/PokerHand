package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.Test;


import static com.thoughtworks.gameoflife.CellState.DEAD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;


import static com.thoughtworks.gameoflife.CellState.ALIVE;
import static org.hamcrest.Matchers.is;

public class GridTest {

    @Test
    void shouldReturnCellStateAsAliveWhenTheCellIsAlive() {
        Coordinate coordinate=new Coordinate(1,1);
        Cell cell = new Cell(coordinate,ALIVE);
        CellState expectedState = ALIVE;

        CellState actualState = cell.getState();

        assertThat(actualState, is(expectedState));
    }

    @Test
    void shouldReturnCellStateAsDeadWhenTheCellIsDead() {
        Coordinate coordinate=new Coordinate(1,1);
        Cell cell = new Cell(coordinate,DEAD);
        CellState expectedState = DEAD;

        CellState actualState = cell.getState();

        assertThat(actualState, is(expectedState));
    }
}
