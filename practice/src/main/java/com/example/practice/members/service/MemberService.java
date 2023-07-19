package com.example.practice.members.service;

import com.example.practice.config.exception.ExistEmailException;
import com.example.practice.config.exception.LoginFailException;
import com.example.practice.config.service.MemberLoginService;
import com.example.practice.members.domain.entity.Member;
import com.example.practice.members.domain.response.MemberResponse;
import com.example.practice.members.repository.MemberRepository;
import com.example.practice.members.domain.request.LoginRequest;
import com.example.practice.members.domain.request.SignupRequest;
import com.example.practice.members.domain.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberLoginService memberLoginService;

    public void insert(SignupRequest request){
        Optional<Member> byEmail = memberRepository.findByEmail(request.email());
        if(byEmail.isPresent()) throw new ExistEmailException("있는 거");
        memberRepository.save(request.toEntity());
    }

    public LoginResponse login(LoginRequest request){
        Optional<Member> byEmailAndPassword =
                memberRepository
                        .findByEmailAndPassword(request.email(), request.password());
        Member member = byEmailAndPassword
                .orElseThrow(() -> new LoginFailException("없는 유저"));
        memberLoginService.insert(member);
        return new LoginResponse(member.getId(), member.getName(), member.getAge());
    }

    public Page<MemberResponse> findAll(PageRequest request){
        Page<Member> allBy = memberRepository.findAllFetch(request);
        return allBy.map(MemberResponse::new);
    }
}