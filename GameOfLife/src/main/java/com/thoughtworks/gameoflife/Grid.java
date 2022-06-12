package com.thoughtworks.gameoflife;

import java.util.HashSet;

public class Grid {
    HashSet <Cell> cells = new HashSet<Cell>();

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public void checkNeighbors(Cell cell) {
        int[] x = new int[]{-1, 0, +1};
        int[] y = new int[]{-1,0,+1};
        int neighborCellsCount=0;
        int xPosition = cell.coordinate.getXCoordinate();
        int yPosition = cell.coordinate.getYCoordinate();
            for(int xIter=0;xIter<x.length;xIter++) {
                for(int yIter=0;yIter < y.length;yIter++) {
                    for(Cell neighborCell : cells) {
                        //System.out.println("x:"+ (xPosition+x[xIter]) + "y:" + (yPosition+y[yIter]) );
                        neighborCellsCount += countNeighborCells(xPosition, yPosition, neighborCell, x[xIter], y[yIter]);
                       //System.out.println("count:" + neighborCellsCount);
                }
            }
        }
        //System.out.println("count:" + neighborCellsCount);
        cell.changeCellState(neighborCellsCount);
    }

    private int countNeighborCells(int xPosition, int yPosition, Cell neighborCell, int xIter, int yIter) {
        if(xPosition + xIter == xPosition && yPosition + yIter == yPosition)
            return 0;
        if(xPosition + xIter == neighborCell.coordinate.getXCoordinate() && yPosition + yIter == neighborCell.coordinate.getYCoordinate()) {
            if(neighborCell.getState().equals(CellState.ALIVE)) {
                return 1;
            }
        }
        return 0;
    }
}
