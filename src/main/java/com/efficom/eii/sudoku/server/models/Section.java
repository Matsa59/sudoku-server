package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Section {

    private Cell[][] cells;

    public Section() {
        cells = new Cell[3][3];
    }

    public boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (Cell[] cell_array : cells) {
            for (Cell cell : cell_array) {
                if(cell.getValue() != 0) set.add(cell.getValue());
            }
        }

        result = set.size() == 9;

        return result;
    }

    public boolean setCell(int positionX, int positionY, Cell cell) {
        if (positionX < 0
            || positionX > 2
            || positionY < 0
            || positionY > 2
            || cell.getValue() < 1
            || cell.getValue() > 9
        ) {
            return false;
        }

        cells[positionX][positionY] = cell;

        return true;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
