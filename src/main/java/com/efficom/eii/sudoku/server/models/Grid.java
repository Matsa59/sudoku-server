package com.efficom.eii.sudoku.server.models;

public class Grid {

    private Section[] sections;

    public Section[] getSections() {
        return sections;
    }

    public Grid() {
        sections = new Section[9];
        for(Section section : sections) {
            section = new Section();
        }
    }

    public boolean isValid() {
        boolean result = true;

        for (Section section: sections) {
            result = result && section.isValid();
        }

        return result;
    }
}
