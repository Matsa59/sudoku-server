package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Row {

    private static int ROW_SIZE = 9;
    private int[] line;

    public Row() {
        line = new int[ROW_SIZE];
    }

    public void setBox(int x, int value) {
        if(x < 0 && x >= ROW_SIZE)
            throw new IllegalArgumentException();

        line[x] = value;
    }

    public boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (int value : line) {
            if(value != 0) set.add(value);
        }

        result = set.size() == 9;

        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i : line) {
            sb.append(i);
        }

        return sb.toString();
    }
}
