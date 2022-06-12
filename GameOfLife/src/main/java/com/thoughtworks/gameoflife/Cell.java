package com.thoughtworks.gameoflife;

public class Cell {
    Coordinate coordinate;
    CellState state;

    public Cell(Coordinate coordinate, CellState state) {
        this.coordinate = coordinate;
        this.state = state;
    }

    public CellState getState() {
        return this.state;
    }
}
