package com.efficom.eii.sudoku.server.models;

public class Grid {

    private Section[] sections;

    public Section[] getSections() {
        return sections;
    }

    public Grid() {
        sections = new Section[9];
        for(int i = 0; i < 9; i++) {
            sections[i] = new Section();
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
