package com.efficom.eii.sudoku.server.models;

import java.util.HashSet;
import java.util.Set;

public class Section {

    private Position position;
    private int[][] boxes;

    public Section() {
        boxes = new int[3][3];
    }

    public boolean isValid() {
        boolean result;

        Set<Integer> set = new HashSet<>();
        for (int[] line : boxes) {
            for (int value : line) {
                if(value != 0) set.add(value);
            }
        }

        result = set.size() == 9;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(int[][] boxes) {
        this.boxes = boxes;
    }
}
