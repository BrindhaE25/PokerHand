package com.thoughtworks.gameoflife;

public class Cell {
    final int MINIMUM_NEIGHBOR_CELL_COUNT = 2;
    final int MAXIMUM_NEIGHBOR_CELL_COUNT = 3;

    private Coordinate coordinate;
    private CellState state;

    public Cell(Coordinate coordinate, CellState state) {
        this.coordinate = coordinate;
        this.state = state;
    }

    public CellState getState() {
        return this.state;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void changeCellState(int cellCount) {
        if(cellCount < MINIMUM_NEIGHBOR_CELL_COUNT) {
            this.state = CellState.DEAD;

        }
        else if(cellCount > MAXIMUM_NEIGHBOR_CELL_COUNT){
            this.state = CellState.DEAD;
        }
        else if(cellCount == MAXIMUM_NEIGHBOR_CELL_COUNT || cellCount == MINIMUM_NEIGHBOR_CELL_COUNT){
            this.state = CellState.ALIVE;
        }
    }


}
