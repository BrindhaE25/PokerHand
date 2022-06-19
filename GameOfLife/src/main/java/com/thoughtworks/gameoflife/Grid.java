package com.thoughtworks.gameoflife;

import java.util.HashSet;

public class Grid {
    HashSet<Cell> cells = new HashSet<>();

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public void checkNeighbors(Cell cell) {
        int neighborCellsCount = 0;
        for (Cell neighborCell : cells) {
            for (CellDirection direction : CellDirection.values())
                neighborCellsCount += countNeighborCells(cell, neighborCell, direction.getXPosition(), direction.getYPosition());
        }

        cell.changeCellState(neighborCellsCount);
    }

    private int countNeighborCells(Cell cell, Cell neighborCell, int xPosition, int yPosition) {
        if (cell.getCoordinate().getXCoordinate() + xPosition == neighborCell.getCoordinate().getXCoordinate() &&
                cell.getCoordinate().getYCoordinate() + yPosition == neighborCell.getCoordinate().getYCoordinate() &&
                neighborCell.getState().equals(CellState.ALIVE)) {
            return 1;
        }
        return 0;
    }
}
