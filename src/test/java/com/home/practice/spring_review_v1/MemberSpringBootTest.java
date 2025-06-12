package com.home.practice.spring_review_v1;

import com.home.practice.spring_review_v1.domain.Member;
import com.home.practice.spring_review_v1.repository.MemberRepository;
import com.home.practice.spring_review_v1.service.MemberService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class MemberSpringBootTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void afterEach() {
        memberRepository.storeClear();
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void join(){
        Member member = new Member();
        member.setName("윤지호");

        Long memberId = memberService.join(member);
        Member result = memberService.findByOne(memberId).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    @DisplayName("중복 회원 가입")
    void DuplicateJoin(){
        Member member = new Member();
        member.setName("윤지호");

        Member member1 = new Member();
        member1.setName("윤지호");

        memberService.join(member);

        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member1));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
    }

    @Test
    @DisplayName("findMembers")
    void findMembers(){
        Member member = new Member();
        member.setName("윤지호");

        Member member1 = new Member();
        member1.setName("윤지호2");

        memberService.join(member);
        memberService.join(member1);
        List<Member> all = memberService.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("findByOne")
    void findByOne(){
        Member member = new Member();
        member.setName("윤지호");

        Long memberId = memberService.join(member);

        Member findByOne = memberService.findByOne(memberId).get();

        assertThat(findByOne).isEqualTo(member);
    }
}
