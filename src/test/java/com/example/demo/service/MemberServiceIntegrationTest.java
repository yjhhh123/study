package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("join 테스트")
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long memberId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(memberId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    @DisplayName("중복 회원 예외")
    void duplicate_join(){
        //given
        Member member1 = new Member();
        member1.setName("test1");

        Member member2 = new Member();
        member2.setName("test1");

        //when
        memberService.join(member1);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");

        //then

    }

    @Test
    @DisplayName("findMembers 테스트")
    void findMembers() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.join(member2);


        List<Member> members = memberService.findMembers();
        assertThat(members.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("findOne 테스트")
    void findOne() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.join(member2);

        Member member = memberService.findOne(member1.getId()).get();

        assertThat(member1.getId()).isEqualTo(member.getId());
    }
}
