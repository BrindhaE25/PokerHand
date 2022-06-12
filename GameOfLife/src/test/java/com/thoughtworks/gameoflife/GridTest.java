package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.gameoflife.CellState.DEAD;
import static org.hamcrest.MatcherAssert.assertThat;

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

    @Test
    void shouldReturnCellStateAsDeadWhenTheCellHasFewerThanTwoAliveNeighbors() {
        CellState expectedState = DEAD;
        Coordinate coordinate=new Coordinate(1,1);
        Cell cell = new Cell(coordinate,ALIVE);
        System.out.println(cell);
        Coordinate anotherCoordinate = new Coordinate(1,2);
        Cell anotherCell = new Cell(anotherCoordinate,ALIVE);
        System.out.println(anotherCell);
        Grid grid = new Grid();
        grid.addCell(cell);
        grid.addCell(anotherCell);

        grid.checkNeighbors(cell);
        CellState actualState = cell.getState();

        assertThat(actualState, is(expectedState));
    }

    @Test
    void shouldReturnCellStateAsDeadWhenTheCellHasMoreThanThreeAliveNeighbors() {
        CellState expectedState = DEAD;
        Coordinate firstCoordinate=new Coordinate(1,1);
        Cell firstCell = new Cell(firstCoordinate,ALIVE);
        Coordinate secondCoordinate = new Coordinate(1,2);
        Cell secondCell = new Cell(secondCoordinate,ALIVE);
        Coordinate thirdCoordinate = new Coordinate(0,1);
        Cell thirdCell = new Cell(thirdCoordinate,ALIVE);
        Coordinate fourthCoordinate = new Coordinate(1,0);
        Cell fourthCell = new Cell(fourthCoordinate,ALIVE);
        Coordinate fifthCoordinate = new Coordinate(1,0);
        Cell fifthCell = new Cell(fifthCoordinate,ALIVE);
        Grid grid = new Grid();
        grid.addCell(firstCell);
        grid.addCell(secondCell);
        grid.addCell(thirdCell);
        grid.addCell(fourthCell);
        grid.addCell(fifthCell);

        grid.checkNeighbors(firstCell);
        CellState actualState = firstCell.getState();

        assertThat(actualState, is(expectedState));
    }

    @Test
    void shouldReturnCellStateAsAliveWhenTheCellHasTwoOrThreeAliveNeighbors() {
        CellState expectedState = ALIVE;
        Coordinate firstCoordinate=new Coordinate(1,1);
        Cell firstCell = new Cell(firstCoordinate,ALIVE);
        Coordinate secondCoordinate = new Coordinate(1,2);
        Cell secondCell = new Cell(secondCoordinate,ALIVE);
        Coordinate thirdCoordinate = new Coordinate(0,1);
        Cell thirdCell = new Cell(thirdCoordinate,ALIVE);
        Grid grid = new Grid();
        grid.addCell(firstCell);
        grid.addCell(secondCell);
        grid.addCell(thirdCell);

        grid.checkNeighbors(firstCell);
        CellState actualState = firstCell.getState();

        assertThat(actualState, is(expectedState));
    }

    @Test
    void shouldReturnCellStateAsAliveWhenTheCellIsDeadAndItHasThreeAliveNeighbors() {
        CellState expectedState = ALIVE;
        Coordinate firstCoordinate=new Coordinate(1,1);
        Cell firstCell = new Cell(firstCoordinate,DEAD);
        Coordinate secondCoordinate = new Coordinate(1,2);
        Cell secondCell = new Cell(secondCoordinate,ALIVE);
        Coordinate thirdCoordinate = new Coordinate(0,1);
        Cell thirdCell = new Cell(thirdCoordinate,ALIVE);
        Coordinate fourthCoordinate = new Coordinate(1,0);
        Cell fourthCell = new Cell(fourthCoordinate,ALIVE);
        Grid grid = new Grid();
        grid.addCell(firstCell);
        grid.addCell(secondCell);
        grid.addCell(thirdCell);
        grid.addCell(fourthCell);

        grid.checkNeighbors(firstCell);
        CellState actualState = firstCell.getState();

        assertThat(actualState, is(expectedState));
    }

}
