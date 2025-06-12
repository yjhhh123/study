package com.home.practice.spring_reviewv2_jpa.repository;

import com.home.practice.spring_reviewv2_jpa.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberRepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    @DisplayName("findByName 테스트")
    void findByNameTest(){
        Member member = new Member();
        member.setName("윤지호");

        memberRepository.save(member);
        Member findMember = memberRepository.findByName("윤지호").get();

        assertThat(findMember).isEqualTo(member);
    }
}