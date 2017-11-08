package com.efficom.eii.sudoku.server.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


public class Grid {

    @JsonIgnore private Block[] blocks;
    @JsonIgnore private Row[] rows;
    @JsonIgnore private Column[] columns;

    public Grid() {
        blocks = new Block[9];
        rows = new Row[9];
        columns = new Column[9];
        for(int i = 0; i < 9; i++) {
            blocks[i] = new Block();
            rows[i] = new Row();
            columns[i] = new Column();
        }
    }

    public void setCell(int x, int y, int value) {
        Cell cell = new Cell(value);
        blocks[x / 3 + y / 3].setCell(x%3, y%3, cell);
        rows[y].setCell(x, cell);
        columns[x].setCell(y, cell);
    }

    public void setValue(int x, int y, int value) {
        Cell cell = columns[x].getCell(y);
        cell.setValue(value);
    }



    @JsonIgnore
    public boolean isValid() {
        boolean result = true;

        for (Block block : blocks) {
            result = result && block.isValid();
        }
        for (Row row: rows) {
            result = result && row.isValid();
        }
        for (Column col: columns) {
            result = result && col.isValid();
        }

        return result;
    }


    @JsonGetter("sudoku")
    public String getSudoku() {
        StringBuilder sb = new StringBuilder();

        for(Row row : rows) {
            sb.append(row.toString());
        }

        return sb.toString();
    }


    @JsonSetter("sudoku")
    public void setSudoku(String sudoku) {
        if(sudoku.length() != 81)
            throw new IllegalArgumentException("String should have a length of 81");

        for(int i=0; i<sudoku.length(); i++) {
            int value = Character.getNumericValue(sudoku.charAt(i));
            this.setCell(i%9, i/9, value);
        }
    }
}
