package com.efficom.eii.sudoku.server.controllers;

import com.efficom.eii.sudoku.server.models.Grid;
import org.springframework.web.bind.annotation.*;

@RestController
public class GridController {

    @GetMapping("/grid")
    public Grid get() {
        return new Grid();
    }

    @PostMapping("/grid")
    public Grid post(@RequestBody Grid sudoku) {
        boolean isValid = sudoku.isValid();
        return sudoku;
    }
}

