package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Block {

    private Cell[][] cells;

    public Block() {
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

    public void setCell(int positionX, int positionY, Cell cell) {
        if (positionX < 0|| positionX > 2 || positionY < 0 || positionY > 2)
            throw new IllegalArgumentException();

        cells[positionX][positionY] = cell;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
