package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Column {

    private static int COLUMN_SIZE = 9;
    private Cell[] cells;

    public Column() {
        cells = new Cell[COLUMN_SIZE];
    }

    public void setBox(int y, int value) {
        if(y < 0 && y >= COLUMN_SIZE)
            throw new IllegalArgumentException();

        cells[y].setValue(value);
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
