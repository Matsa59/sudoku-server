package com.efficom.eii.sudoku.server.models;

public class Section {

    private String name;
    private int[][] boxes;

    public Section() {
        boxes = new int[3][3];
    }

    public boolean isValid() {
        boolean result = true;
        return result;
    }

    public boolean setBox(int positionX, int positionY, int value) {
        if (positionX < 0
            || positionX > 2
            || positionY < 0
            || positionY > 2
            || value < 1
            || value > 9
        ) {
            return false;
        }

        boxes[positionX][positionY] = value;

        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(int[][] boxes) {
        this.boxes = boxes;
    }
}
