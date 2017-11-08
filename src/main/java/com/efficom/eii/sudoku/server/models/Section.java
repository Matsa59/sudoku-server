package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Section {

    private Position position;
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

    public boolean SetCell(int positionX, int positionY, int value) {
        if (positionX < 0
            || positionX > 2
            || positionY < 0
            || positionY > 2
            || value < 1
            || value > 9
        ) {
            return false;
        }

        cells[positionX][positionY].setValue(value);

        return true;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
