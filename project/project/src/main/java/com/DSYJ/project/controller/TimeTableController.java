package com.DSYJ.project.controller;

import com.DSYJ.project.domain.ScheduleDTO;
import com.DSYJ.project.service.PostingService;
import com.DSYJ.project.service.ScheduleDTOService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeTable")
public class TimeTableController {

    private final ScheduleDTOService scheduleDTOService;

    public TimeTableController(ScheduleDTOService scheduleDTOService) {
        this.scheduleDTOService = scheduleDTOService;
    }

    @GetMapping("")
    public String timeTable() {
        return "timetable";
    }

    @PostMapping("/save-schedule")
    public ResponseEntity<?> saveSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        // 받은 데이터를 scheduleDTO 객체로 매핑하여 처리
        scheduleDTOService.scheduleSave(scheduleDTO);
        // 예시: 받은 데이터를 그대로 응답
        return new ResponseEntity<>(scheduleDTO, HttpStatus.OK);
    }
}
