package com.efficom.eii.sudoku.server.models;

public class Cell {
    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value=" + value +
                '}';
    }
}
