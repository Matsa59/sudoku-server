package com.efficom.eii.sudoku.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GridController {

    @RequestMapping("/grid")
    public String get() {
        return "hello world";
    }
}
