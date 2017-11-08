package com.efficom.eii.sudoku.server.factories;

import com.efficom.eii.sudoku.server.models.Grid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class GridFactory {
    public static Grid build() {
        Grid grid = new Grid();

        for(int i = 0; i < 9; i++) {
            LinkedList<Integer> numbers = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            for(int j = 0; j < 9; j++) {
                boolean isAlreadyUsed = true;

                do {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, numbers.size());
                    int value = numbers.get(randomNum);

                    if (grid.setCell(i, j, value)) {
                        isAlreadyUsed = false;
                        numbers.remove(randomNum);
                    } else {
                        boolean numberFree = true;

                        for(Integer val : numbers) {
                            numberFree = numberFree
                                    && !grid.getColumns(i).haveValue(value)
                                    && !grid.getRows(j).haveValue(value);
                        }

                        if(!numberFree) {
                            //TODO : permute
                            System.out.println("NOT FREE | PERMUTE");
                            isAlreadyUsed = false;
                        }
                    }
                    
                } while (isAlreadyUsed);
            }
        }

        return grid;
    }
}
