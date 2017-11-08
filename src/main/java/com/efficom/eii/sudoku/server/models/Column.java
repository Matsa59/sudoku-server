package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Column {

    private static int COLUMN_SIZE = 9;
    private Cell[] cells;

    public Column() {
        cells = new Cell[COLUMN_SIZE];
    }

    public void setCell(int y, Cell cell) {
        if(y < 0 && y >= COLUMN_SIZE)
            throw new IllegalArgumentException();


        cells[y] = cell;
    }

    public boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (Cell cell : cells) {
            if(cell.getValue() != 0) set.add(cell.getValue());
        }

        result = set.size() == 9;

        return result;
    }
}
