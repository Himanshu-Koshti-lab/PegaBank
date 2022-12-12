package com.pegabank.pegabank.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DashBoardController {

    @GetMapping("/Welcome")
    public String welcome() {
        return "Welcome Dashboard";
    }

    @GetMapping("/Home")
    public String Home() {
        return "Welcome Home";
    }
}
