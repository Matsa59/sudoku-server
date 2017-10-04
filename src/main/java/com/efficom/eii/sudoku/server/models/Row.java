package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

class Row {

    private static int ROW_SIZE = 9;
    private int[] line;

    Row() {
        line = new int[ROW_SIZE];
    }

    void setBox(int y, int value) {
        if(y < 0 && y >= ROW_SIZE)
            throw new IllegalArgumentException();

        line[y] = value;
    }

    boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (int value : line) {
            set.add(value);
        }

        result = set.size() == 9;

        return result;
    }
}
