package com.home.practice.spring_review_v1.config;

import com.home.practice.spring_review_v1.repository.MemberMemoryRepository;
import com.home.practice.spring_review_v1.repository.MemberRepository;
import com.home.practice.spring_review_v1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig{

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberMemoryRepository();
    }
}
