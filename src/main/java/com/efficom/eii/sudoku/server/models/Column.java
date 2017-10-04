package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Column {

    private static int COLUMN_SIZE = 9;
    private int[] column;

    public Column() {
        column = new int[COLUMN_SIZE];
    }

    public void setBox(int y, int value) {
        if(y < 0 && y >= COLUMN_SIZE)
            throw new IllegalArgumentException();

        column[y] = value;
    }

    public boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (int value : column) {
            if(value != 0) set.add(value);
        }

        result = set.size() == 9;

        return result;
    }
}
