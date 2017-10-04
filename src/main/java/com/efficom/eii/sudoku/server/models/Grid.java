package com.efficom.eii.sudoku.server.models;

public class Grid {

    private Section[] sections;
    private Row[] rows;
    private Column[] columns;

    public Section[] getSections() {
        return sections;
    }
    public Row[] getRows() {
        return rows;
    }
    public Column[] getColumns() {
        return columns;
    }

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
        // TODO :
        // sections[x / 3].setBox();
        rows[x].setBox(y, value);
        columns[x].setBox(y, value);
    }

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
}
