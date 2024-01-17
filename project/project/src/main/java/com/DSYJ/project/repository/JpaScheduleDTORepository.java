package com.DSYJ.project.repository;

import com.DSYJ.project.domain.Posting;
import com.DSYJ.project.domain.ScheduleDTO;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaScheduleDTORepository implements ScheduleDTORepository{
    private final EntityManager em;

    public JpaScheduleDTORepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        em.persist(scheduleDTO);
        return scheduleDTO;
    }

    @Override
    public List<ScheduleDTO> findAll() {
        return em.createQuery("select s from ScheduleDTO s", ScheduleDTO.class)
                .getResultList();
    }
}
