package com.home.practice.spring_review_v1.service;

import com.home.practice.spring_review_v1.domain.Member;
import com.home.practice.spring_review_v1.repository.MemberMemoryRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class MemberServiceTest {

    MemberMemoryRepository memberMemoryRepository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberMemoryRepository = new MemberMemoryRepository();
        memberService = new MemberService(memberMemoryRepository);
    }

    @AfterEach
    public void afterEach(){
        memberMemoryRepository.storeClear();
    }

    @DisplayName("회원 가입 성공 테스트")
    @Test
    void join_success() {
        Member member = new Member();
        member.setName("윤지호");

        Long memberId = memberService.join(member);
        Member findByOne = memberService.findByOne(memberId).get();

        assertThat(member).isEqualTo(findByOne);
    }

    @DisplayName("중복 회원 가입")
    @Test
    void duplicated_join() {
        Member member = new Member();
        member.setName("윤지호");

        Member member1 = new Member();
        member1.setName("윤지호");

        memberService.join(member);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
    }

    @DisplayName("전체 조회")
    @Test
    void findAll() {
        Member member = new Member();
        member.setName("윤지호");

        Member member1 = new Member();
        member1.setName("윤지호2");

        memberService.join(member);
        memberService.join(member1);

        List<Member> memberList = memberService.findAll();

        assertThat(memberList.size()).isEqualTo(2);
    }

    @DisplayName("회원 한명 조회")
    @Test
    void findByOne() {
        Member member = new Member();
        member.setName("윤지호");

        Long memberId = memberService.join(member);
        Member findMember = memberService.findByOne(memberId).get();

        assertThat(member).isEqualTo(findMember);

    }
}