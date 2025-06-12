package com.home.practice.spring_review_v1.service;

import com.home.practice.spring_review_v1.domain.Member;
import com.home.practice.spring_review_v1.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

   private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        validDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validDuplicatedMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Optional<Member> findByOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
