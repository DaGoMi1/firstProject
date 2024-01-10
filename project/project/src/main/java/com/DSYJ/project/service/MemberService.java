package com.DSYJ.project.service;


import com.DSYJ.project.domain.Member;
import com.DSYJ.project.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getUserId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUserId(member.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId) {
        return memberRepository.findByUserId(memberId);
    }

    public Member findByUserIdAndPassword(String userId, String password) {
        return memberRepository.findByUserIdAndPassword(userId, password)
                .orElse(null); // orElse를 사용하여 Optional에서 Member 객체를 꺼냅니다.
    }

    public void updateMember(Member member){
        Member existingMember = memberRepository.
                findById(member.getId()).orElse(null);

        if (existingMember != null) {
            existingMember.setName(member.getName());
            // 저장
            memberRepository.save(existingMember);
        } else {
            // 사용자가 존재하지 않는 경우에 대한 처리 로직 추가
            throw new IllegalArgumentException("사용자가 존재하지 않습니다.");
        }
    }
}

