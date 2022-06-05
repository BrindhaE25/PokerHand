package com.thoughtworks.gameoflife;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class GameOfLife {
    public String play(String input) {
        String[] inputPosition = input.split("\n");
        int[][] grid = new int[5][5];
        int[][] outputGrid = new int[5][5];
        int count = 0;
        String outputString = "";

        String[] position;
        for (int iter = 0; iter < inputPosition.length; iter++) {
            position = inputPosition[iter].split(" ");
            grid[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = 1;
        }
        int row = grid.length;
        int column = grid[0].length;

        for (int rowIter = 0; rowIter < row; rowIter++) {
            for (int columnIter = 0; columnIter < column; columnIter++) {
                for (int rowNeighbour = Math.max(0, rowIter -1); rowNeighbour < Math.min(row, rowIter + 2); rowNeighbour++) {
                    for (int columnNeighbour = Math.max(0, columnIter -1); columnNeighbour < Math.min(column, columnIter + 2); columnNeighbour++) {
                        if (rowNeighbour != rowIter || columnNeighbour != columnIter) {
                            if(grid[rowNeighbour][columnNeighbour]==1) count++;
                        }
                    }
                }
                if(count==3 && grid[rowIter][columnIter]==0) {
                    outputGrid[rowIter][columnIter] =1;
                }
                else if((count == 2 || count==3) && grid[rowIter][columnIter] == 1) {
                    outputGrid[rowIter][columnIter] = 1;
                }
                count=0;
            }
        }
        for(int a=0;a<5;a++) {
            for(int b=0;b<5;b++) {
                if(outputGrid[a][b]==1)
                    outputString += a + " " + b + "\n";
            }
        }
        return outputString;
    }
}