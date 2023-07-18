package com.example.practice.members.service;

import com.example.practice.members.domain.config.domain.entity.MemberLogin;
import com.example.practice.members.domain.config.domain.service.MemberLoginService;
import com.example.practice.members.domain.entity.Member;
import com.example.practice.members.repository.MemberRepository;
import com.example.practice.members.request.LoginRequest;
import com.example.practice.members.request.SignupRequest;
import com.example.practice.members.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberLoginService memberLoginService;

    // 회원가입
    //    public void insert(email, password, name, age){ 이렇게 쓰면 너무 지저분하니까 Request를 만듭시다
    public void insert(SignupRequest request){
        memberRepository.save(request.toEntity());
    }


    // 로그인
    public LoginResponse login(LoginRequest request){
        Optional<Member> byEmailPassword =
            memberRepository.
                findByEmailAndPassword(request.email(), request.password());

        Member member = byEmailPassword
                .orElseThrow(() -> new RuntimeException("없는 유저"));
//        new MemberLogin(member, LocalDateTime.now());
        memberLoginService.insert(member);
        return new LoginResponse(member.getId(), member.getName(), member.getAge());

    }
}
