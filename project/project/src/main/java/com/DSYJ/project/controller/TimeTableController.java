package com.DSYJ.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeTableController {

    @GetMapping("/timeTable")
    public String timeTable(){
        return "timetable";
    }
}
