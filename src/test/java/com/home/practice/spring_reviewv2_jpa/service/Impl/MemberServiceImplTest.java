package com.home.practice.spring_reviewv2_jpa.service.Impl;

import com.home.practice.spring_reviewv2_jpa.domain.Member;
import com.home.practice.spring_reviewv2_jpa.exception.MemberNotFoundException;
import com.home.practice.spring_reviewv2_jpa.exception.MemberValidException;
import com.home.practice.spring_reviewv2_jpa.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    @Test
    @DisplayName("회원 저장 테스트")
    void saveTest() {
        Member member = new Member();
        member.setName("윤지호");

        when(memberRepository.save(any(Member.class))).thenReturn(member);
        Member savedMember = memberService.saveMember(member);

        assertEquals("윤지호", savedMember.getName());
        verify(memberRepository,times(1)).save(any(Member.class));
    }

    @Test
    @DisplayName("Id로 회원 조회 테스트")
    void findByIdTest(){
        Member member = new Member();
        member.setId(1L);
        member.setName("윤지호");

        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        Optional<Member> findById = memberService.findById(1L);

        assertThat(findById.get().getName()).isEqualTo("윤지호");
    }

    @Test
    @DisplayName("이름으로 회원 조회 테스트")
    void findByName() {
        Member member = new Member();
        member.setId(1L);
        member.setName("윤지호");

        when(memberRepository.findByName("윤지호")).thenReturn(Optional.of(member));
        Optional<Member> findByNameMember = memberService.findByName("윤지호");

        assertThat(findByNameMember).isPresent();
        assertThat(findByNameMember.get()).isEqualTo(member);
    }

    @Test
    @DisplayName("전체 회원 조회 테스트")
    void findByAllTest() {
        Member member = new Member();
        member.setId(1L);
        member.setName("윤지호1");

        Member member1 = new Member();
        member1.setId(2L);
        member1.setName("윤지호2");

        List<Member> memberList = List.of(new Member[]{member, member1});

        when(memberRepository.findAll()).thenReturn(memberList);
        List<Member> all = memberService.findAll();

        assertThat(all.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("중복이름 회원가입")
    void duplicatedSaveTest() {
        Member member = new Member();
        member.setId(1L);
        member.setName("윤지호");
        
        when(memberRepository.findByName(member.getName())).thenReturn(Optional.of(new Member()));

        assertThrows(MemberValidException.class, () -> memberService.saveMember(member));
    }

    @Test
    @DisplayName("Id로 없는 회원 조회시 예외")
    void findByIdNotFoundTest() {
        when(memberRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(MemberNotFoundException.class, () -> memberService.findById(1L));
    }

    @Test
    @DisplayName("이름으로 없는 회원 조회시 예외")
    void findByNameNotFoundException() {
        when(memberRepository.findByName("test")).thenReturn(Optional.empty());

        assertThrows(MemberNotFoundException.class, () -> memberService.findByName("test"));
    }

    @Test
    @DisplayName("전체 회원 조회시 회원이 없을 때 예외")
    void findAllNotFoundException() {
        List<Member> memberList = List.of();
        when(memberRepository.findAll()).thenReturn(memberList);

        assertThrows(MemberNotFoundException.class, () -> memberService.findAll());
    }
}