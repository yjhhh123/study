package com.home.practice.spring_reviewv2_jpa.service;

import com.home.practice.spring_reviewv2_jpa.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member saveMember(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
