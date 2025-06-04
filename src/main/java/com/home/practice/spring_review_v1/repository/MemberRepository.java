package com.home.practice.spring_review_v1.repository;

import com.home.practice.spring_review_v1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    void storeClear();
}
