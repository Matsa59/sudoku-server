package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

class Column {

    private static int COLUMN_SIZE = 9;
    private int[] column;

    Column() {
        column = new int[COLUMN_SIZE];
    }

    void setBox(int y, int value) {
        if(y < 0 && y >= COLUMN_SIZE)
            throw new IllegalArgumentException();

        column[y] = value;
    }

    boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (int value : column) {
            set.add(value);
        }

        result = set.size() == 9;

        return result;
    }
}
