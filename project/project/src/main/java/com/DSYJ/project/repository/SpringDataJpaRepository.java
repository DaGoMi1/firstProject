package com.DSYJ.project.repository;

import com.DSYJ.project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaRepository extends JpaRepository<Member, String>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
