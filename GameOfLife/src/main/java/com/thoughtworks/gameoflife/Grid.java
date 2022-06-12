package com.thoughtworks.gameoflife;

import java.util.HashSet;

public class Grid {
    HashSet <Cell> cells;

    public void createCell(Cell newCell) {
        cells.add(newCell);
    }
}
