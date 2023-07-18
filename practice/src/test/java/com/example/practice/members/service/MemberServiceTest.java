package com.example.practice.members.service;

import com.example.practice.members.domain.config.domain.entity.MemberLogin;
import com.example.practice.members.domain.config.domain.repository.MemberLoginRepository;
import com.example.practice.members.domain.entity.Member;
import com.example.practice.members.repository.MemberRepository;
import com.example.practice.members.request.LoginRequest;
import com.example.practice.members.request.SignupRequest;
import com.example.practice.members.response.LoginResponse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberLoginRepository memberLoginRepository;

    @BeforeEach
    void init() {
        String email = "1111";
        String password = "1234";
        LoginRequest loginRequest = new LoginRequest(email, password);
        Member member = new Member(null, email, password, "name", 10, null, null);
        memberRepository.save(member);
    }

    @AfterEach
    void clear(){
        memberRepository.deleteAll();
        memberLoginRepository.deleteAll();
    }






    @Test
    void insert() {

        //given
        String email = "ssss";
        String password = "1234";
        String name = "uuuu";
        Integer age = 10;

        SignupRequest signupRequest = new SignupRequest(email, password, name, age);


        //when
        memberService.insert(signupRequest);


        //then
        List<Member> all = memberRepository.findAll();
        assertThat(all).hasSize(1);
        assertThat(all.get(0).getEmail()).isEqualTo(email);

    }




    @Test @Transactional
    void 기본로그인_멤버로그인_인서트_체크() {

        //given
        String email = "1111";
        String password = "1234";
        LoginRequest loginRequest = new LoginRequest(email, password);
        Member member = new Member(null, email, password, "name", 10, null, null);
        memberRepository.save(member);

        //when
        LoginResponse login = memberService.login(loginRequest);

        //then
        assertThat(login.age()).isEqualTo(10);
        assertThat(login.name()).isEqualTo("name");
        assertThat(login.id()).isNotNull();

        List<MemberLogin> all = memberLoginRepository.findAll();
        assertThat(all).hasSize(1);
        assertThat(all.get(0).getMember()).isEqualTo(member);
        assertThat(all.get(0).getCreateAt()).isBefore(LocalDateTime.now());
        assertThat(all.get(0).getEndAt()).isAfter(LocalDateTime.now());

    }


    @Test
    void 로그인시_없는유저() {
        //given
        String email = "11dd1133";
        String password = "1234";
        LoginRequest loginRequest = new LoginRequest(email, password);
//        Member member = new Member(null, email+333, password, "name", 10, null, null);
//        memberRepository.save(member);


        RuntimeException runtimeException = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class
                , () -> memberService.login(loginRequest));


        //then
        assertThat(runtimeException).hasMessage("없는 유저");
    }

}