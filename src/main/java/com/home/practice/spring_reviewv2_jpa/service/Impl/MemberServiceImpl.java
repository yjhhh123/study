package com.home.practice.spring_reviewv2_jpa.service.Impl;

import com.home.practice.spring_reviewv2_jpa.domain.Member;
import com.home.practice.spring_reviewv2_jpa.exception.MemberNotFoundException;
import com.home.practice.spring_reviewv2_jpa.exception.MemberValidException;
import com.home.practice.spring_reviewv2_jpa.repository.MemberRepository;
import com.home.practice.spring_reviewv2_jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new MemberValidException("중복 이름 회원 가입!");
        });
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberRepository.findById(id).orElseThrow(
                () -> new MemberNotFoundException("회원 ID가 없다! " + id)
                )
        );
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.ofNullable(memberRepository.findByName(name).orElseThrow(
                () -> new MemberNotFoundException("회원 이름이 없다! " + name)
                )
        );
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = memberRepository.findAll();
        if (memberList.isEmpty()) {
            throw new MemberNotFoundException("등록된 회원이 없다!");
        }
        return memberList;
    }
}
