package com.efficom.eii.sudoku.server.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


public class Grid {

    @JsonIgnore private Section[] sections;
    @JsonIgnore private Row[] rows;
    @JsonIgnore private Column[] columns;

    public Grid() {
        sections = new Section[9];
        rows = new Row[9];
        columns = new Column[9];
        for(int i = 0; i < 9; i++) {
            sections[i] = new Section();
            rows[i] = new Row();
            columns[i] = new Column();
        }
    }

    public void set(int x, int y, int value) {
        Cell cell = new Cell(value);
        sections[x / 3 + y / 3].setCell(x%3, y%3, cell);
        rows[y].setCell(x, cell);
        columns[x].setCell(y, cell);
    }

    @JsonIgnore
    public boolean isValid() {
        boolean result = true;

        for (Section section: sections) {
            result = result && section.isValid();
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
            this.set(i%9, i/9, value);
        }
    }
}
