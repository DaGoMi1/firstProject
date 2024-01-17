package com.DSYJ.project.service;

import com.DSYJ.project.domain.ScheduleDTO;
import com.DSYJ.project.repository.ScheduleDTORepository;
import jakarta.transaction.Transactional;

@Transactional
public class ScheduleDTOService {

    private final ScheduleDTORepository scheduleDTORepository;


    public ScheduleDTOService(ScheduleDTORepository scheduleDTORepository) {
        this.scheduleDTORepository = scheduleDTORepository;
    }

    public long scheduleSave(ScheduleDTO scheduleDTO){
        scheduleDTORepository.save(scheduleDTO);
        return scheduleDTO.getId();
    }
}
