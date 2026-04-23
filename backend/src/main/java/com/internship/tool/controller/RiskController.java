package com.internship.tool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskController {

    @GetMapping("/")
    public String test() {
        return "Project Running Successfully!";
    }
}