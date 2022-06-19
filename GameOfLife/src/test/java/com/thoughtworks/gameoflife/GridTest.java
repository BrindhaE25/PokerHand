package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.gameoflife.CellState.DEAD;
import static org.hamcrest.MatcherAssert.assertThat;

import static com.thoughtworks.gameoflife.CellState.ALIVE;
import static org.hamcrest.Matchers.is;

public class GridTest {

    @Test
    void shouldReturnCellStateAsDeadWhenTheCellHasFewerThanTwoAliveNeighbors() {
        Coordinate coordinate = new Coordinate(1, 1);
        Cell cell = Cell.createAliveCell(coordinate);
        Coordinate anotherCoordinate = new Coordinate(1, 2);
        Cell anotherCell = Cell.createAliveCell(anotherCoordinate);
        Grid grid = new Grid();
        grid.addCell(cell);
        grid.addCell(anotherCell);

        grid.checkNeighbors(cell);
        CellState actualState = cell.getState();

        assertThat(actualState, is(DEAD));
    }

    @Test
    void shouldReturnCellStateAsDeadWhenTheCellHasMoreThanThreeAliveNeighbors() {
        Coordinate firstCoordinate = new Coordinate(1, 1);
        Cell firstCell = Cell.createAliveCell(firstCoordinate);
        Coordinate secondCoordinate = new Coordinate(1, 2);
        Cell secondCell = Cell.createAliveCell(secondCoordinate);
        Coordinate thirdCoordinate = new Coordinate(0, 1);
        Cell thirdCell = Cell.createAliveCell(thirdCoordinate);
        Coordinate fourthCoordinate = new Coordinate(1, 0);
        Cell fourthCell = Cell.createAliveCell(fourthCoordinate);
        Coordinate fifthCoordinate = new Coordinate(1, 0);
        Cell fifthCell = Cell.createAliveCell(fifthCoordinate);
        Grid grid = new Grid();
        grid.addCell(firstCell);
        grid.addCell(secondCell);
        grid.addCell(thirdCell);
        grid.addCell(fourthCell);
        grid.addCell(fifthCell);

        grid.checkNeighbors(firstCell);
        CellState actualState = firstCell.getState();

        assertThat(actualState, is(DEAD));
    }

    @Test
    void shouldReturnCellStateAsAliveWhenTheCellHasTwoOrThreeAliveNeighbors() {
        Coordinate firstCoordinate = new Coordinate(1, 1);
        Cell firstCell = Cell.createAliveCell(firstCoordinate);
        Coordinate secondCoordinate = new Coordinate(1, 2);
        Cell secondCell = Cell.createAliveCell(secondCoordinate);
        Coordinate thirdCoordinate = new Coordinate(0, 1);
        Cell thirdCell = Cell.createAliveCell(thirdCoordinate);
        Grid grid = new Grid();
        grid.addCell(firstCell);
        grid.addCell(secondCell);
        grid.addCell(thirdCell);

        grid.checkNeighbors(firstCell);
        CellState actualState = firstCell.getState();

        assertThat(actualState, is(ALIVE));
    }

    @Test
    void shouldReturnCellStateAsAliveWhenTheCellIsDeadAndItHasThreeAliveNeighbors() {
        Coordinate firstCoordinate = new Coordinate(1, 1);
        Cell firstCell = Cell.createDeadCell(firstCoordinate);
        Coordinate secondCoordinate = new Coordinate(1, 2);
        Cell secondCell = Cell.createAliveCell(secondCoordinate);
        Coordinate thirdCoordinate = new Coordinate(0, 1);
        Cell thirdCell = Cell.createAliveCell(thirdCoordinate);
        Coordinate fourthCoordinate = new Coordinate(1, 0);
        Cell fourthCell = Cell.createAliveCell(fourthCoordinate);
        Grid grid = new Grid();
        grid.addCell(firstCell);
        grid.addCell(secondCell);
        grid.addCell(thirdCell);
        grid.addCell(fourthCell);

        grid.checkNeighbors(firstCell);
        CellState actualState = firstCell.getState();

        assertThat(actualState, is(ALIVE));
    }

}
