package com.DSYJ.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentIntroductionController {
    @GetMapping("/student")
    public String student() {
        return "student";
    }

    @GetMapping("/major")
    public String mahor() {
        return "major";
    }

}
