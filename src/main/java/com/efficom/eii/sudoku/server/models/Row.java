package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Row {

    private static int ROW_SIZE = 9;
    private Cell[] cells;

    public Row() {
        cells = new Cell[ROW_SIZE];
    }

    public void setCell(int x, Cell cell) {
        if(x < 0 && x >= ROW_SIZE)
            throw new IllegalArgumentException();

        cells[x] = cell;
    }

    public boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (Cell cell : cells) {
            if(cell.getValue() != 0)
                set.add(cell.getValue());
        }

        result = set.size() == 9;

        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Cell cell : cells) {
            sb.append(cell != null ? cell.getValue() : 0);
        }

        return sb.toString();
    }
}
