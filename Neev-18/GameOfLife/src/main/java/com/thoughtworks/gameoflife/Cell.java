package com.thoughtworks.gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cell {
    final int MINIMUM_NEIGHBOR_CELL_COUNT = 2;
    final int MAXIMUM_NEIGHBOR_CELL_COUNT = 3;

    private Coordinate coordinate;
    private CellState state;

    private Cell(Coordinate coordinate, CellState state) {
        this.coordinate = coordinate;
        this.state = state;
    }

    public static Cell createAliveCell(Coordinate coordinate) {
        return new Cell(coordinate, CellState.ALIVE);
    }

    public static Cell createDeadCell(Coordinate coordinate) {
        return new Cell(coordinate, CellState.DEAD);
    }

    public CellState getState() {
        return this.state;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void changeCellState(int cellCount) {
        if (cellCount < MINIMUM_NEIGHBOR_CELL_COUNT) {
            this.state = CellState.DEAD;
        } else if (cellCount > MAXIMUM_NEIGHBOR_CELL_COUNT) {
            this.state = CellState.DEAD;
        } else if (cellCount == MAXIMUM_NEIGHBOR_CELL_COUNT || cellCount == MINIMUM_NEIGHBOR_CELL_COUNT) {
            this.state = CellState.ALIVE;
        }
    }

    public void change() throws FileNotFoundException {
        File file=new File("input.txt");
        Scanner sc = new Scanner(file);
        int cnt = 0;
        char last = '1' ;
        String s1 = null,s2 = null,s3 = null;
        //file to be scanned
        while (sc.hasNextLine()) {
            if(s1 == null) {

                s1 = sc.nextLine();
            }
            else if(s2 == null)
                s2 = sc.nextLine();
            else if(s3 == null)
               s3 = sc.nextLine();
            char[] i1;
            char[] i2;
            char[] i3;
            if(s1 != null && s2 != null && s3 != null) {
                i1 = s1.toCharArray();
                i2 = s2.toCharArray();
                i3 = s3.toCharArray();
            }
]            last = '1';
            for(int i=0;i<i1.length && s1!= null;i++) {
                for(int j=0;j< i2.length && s2!= null;j++) {
                    if(i1[i] == i2[j] &&  i1[i] != last) {
                        for(int k=0;k<i3.length && s3!= null;k++) {
                            if(i1[i] >= 65 && i1[i] <= 92) {
                                cnt = cnt + (i1[i] - 64) +26;
                                System.out.println((i1[i] - 64) + 26);

                            }


                            else {
                                System.out.println((i1[i] - 96));
                                cnt = cnt + (i1[i] - 96);
                            }
                            last = i1[i];
                            s1 = null;
                            s2 = null;
                            s3 = null;

                        }



                    }

                }
            }
        }
        System.out.println(cnt);
    }


}
