package com.home.practice.spring_review_v1.service;

import com.home.practice.spring_review_v1.domain.Member;
import com.home.practice.spring_review_v1.repository.MemberMemoryRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

   private final MemberMemoryRepository memberMemoryRepository;

    public MemberService(MemberMemoryRepository memberMemoryRepository) {
        this.memberMemoryRepository = memberMemoryRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        validDuplicatedMember(member);
        memberMemoryRepository.save(member);
        return member.getId();
    }

    private void validDuplicatedMember(Member member){
        memberMemoryRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findAll(){
        return memberMemoryRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Optional<Member> findByOne(Long memberId){
        return memberMemoryRepository.findById(memberId);
    }


}
