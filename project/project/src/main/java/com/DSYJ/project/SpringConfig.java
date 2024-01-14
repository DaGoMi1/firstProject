package com.DSYJ.project;

import com.DSYJ.project.repository.*;
import com.DSYJ.project.service.MemberService;
import com.DSYJ.project.service.PostingService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public PostingService postingService() {
        return new PostingService(postingRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public PostingRepository postingRepository() {
        return new JpaPostingRepository(em);
    }
}
