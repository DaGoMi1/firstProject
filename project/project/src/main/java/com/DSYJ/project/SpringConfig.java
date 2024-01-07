package com.DSYJ.project;

import com.DSYJ.project.repository.MemberRepository;
import com.DSYJ.project.repository.MemoryMemberRepository;
import com.DSYJ.project.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
