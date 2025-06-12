package com.home.practice.spring_reviewv2_jpa.repository;

import com.home.practice.spring_reviewv2_jpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);
}
