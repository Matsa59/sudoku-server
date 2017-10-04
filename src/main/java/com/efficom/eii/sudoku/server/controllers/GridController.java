package com.efficom.eii.sudoku.server.controllers;

import com.efficom.eii.sudoku.server.models.Grid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GridController {

    @GetMapping("/grid")
    public Grid get() {
        Grid grid = new Grid();
        return new Grid();
    }

    @PostMapping("/grid")
    public String post() {
        return "Post /grid";
    }
}
