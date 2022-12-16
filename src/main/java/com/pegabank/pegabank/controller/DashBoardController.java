package com.pegabank.pegabank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoardController {

    @GetMapping("/Welcome")
    public String welcome() {
        return "Welcome Dashboard";
    }

    @GetMapping("/")
    public String Home() {
        return "Welcome Home";
    }
}
