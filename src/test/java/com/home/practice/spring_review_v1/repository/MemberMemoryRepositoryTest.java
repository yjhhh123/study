package com.home.practice.spring_review_v1.repository;

import com.home.practice.spring_review_v1.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberMemoryRepositoryTest {

    MemberRepository repository = new MemberMemoryRepository();

    @AfterEach
    public void afterEach() {
        repository.storeClear();
    }

    @DisplayName("저장 테스트")
    @Test
    void saveMember() {
        Member member = new Member();
        member.setName("윤지호");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @DisplayName("이름으로 찾기")
    @Test
    void findByName() {
        Member member = new Member();
        member.setName("윤지호");

        repository.save(member);
        Member findByName = repository.findByName("윤지호").get();

        assertThat(findByName).isEqualTo(member);
    }

    @DisplayName("전부 찾기")
    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("윤지호");

        Member member2 = new Member();
        member2.setName("박여렴");

        repository.save(member1);
        repository.save(member2);

        List<Member> memberList = repository.findAll();

        assertThat(memberList.size()).isEqualTo(2);
    }
}