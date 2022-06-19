package com.thoughtworks.gameoflife;

public enum CellDirection {
    NW(-1,-1),
    W(0,-1),
    SW(+1,-1),
    S(+1,0),
    SE(+1,+1),
    E(0,+1),
    NE(-1,+1),
    N(-1,0);


    private final int x,y;
    CellDirection(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }
}
