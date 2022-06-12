package com.thoughtworks.gameoflife;

public class Coordinate {
    final private int xPosition;
    final private int yPosition;

    public Coordinate(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getXCoordinate() {
        return this.xPosition;
    }

    public int getYCoordinate() {
        return this.yPosition;
    }
}
