package com.example.practice.members.domain.config.domain.service;

import com.example.practice.members.domain.config.domain.entity.MemberLogin;
import com.example.practice.members.domain.config.domain.repository.MemberLoginRepository;
import com.example.practice.members.domain.entity.Member;
import com.example.practice.members.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;



@SpringBootTest
@Transactional
class MemberLoginServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberLoginRepository memberLoginRepository;
    @Autowired
    MemberLoginService memberLoginService;
    String email = "1111";
    String password = "1234";
    @BeforeEach
    void init(){
        Member member = new Member(null, email, password, "name", 10, null, null);
        Member save = memberRepository.save(member);
        MemberLogin entity = new MemberLogin(member, LocalDateTime.now());
        memberLoginRepository.save(entity);
    }

    @AfterEach
    void clear(){
        memberRepository.deleteAll();
        memberLoginRepository.deleteAll();
    }

    @Test
    void findByMember() {
//        given
        Long memberId = 1l;
//        when
        Member byMember = memberLoginService.findByMember(memberId);
//        then
        Assertions.assertThat(byMember.getEmail()).isEqualTo(email);
        Assertions.assertThat(byMember.getPassword()).isEqualTo(password);
    }

    @Test
    void insert() {
        //given



        //when


        //then




    }
}