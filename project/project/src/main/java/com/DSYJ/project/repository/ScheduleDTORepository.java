package com.DSYJ.project.repository;

import com.DSYJ.project.domain.ScheduleDTO;

import java.util.List;

public interface ScheduleDTORepository {
    ScheduleDTO save(ScheduleDTO scheduleDTO);
    List<ScheduleDTO> findAll();
}
