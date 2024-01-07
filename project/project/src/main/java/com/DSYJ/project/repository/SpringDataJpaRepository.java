package com.DSYJ.project.repository;

import com.DSYJ.project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRepository extends JpaRepository<Member, String> {
}
