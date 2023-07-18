package com.example.practice.members.domain.config.domain.service;

import com.example.practice.members.domain.config.domain.entity.MemberLogin;
import com.example.practice.members.domain.config.domain.repository.MemberLoginRepository;
import com.example.practice.members.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberLoginService {
    private final MemberLoginRepository memberLoginRepository;

    //  TODO : INSERT
    public void insert(Member member){
        MemberLogin memberLogin = new MemberLogin(member, LocalDateTime.now());
        memberLoginRepository.save(memberLogin);
    }


    //  TODO : LOGINCHECK 하는 것 만들 예정 findByMemberId
    public Member findByMember(Long memberId){
        return null;
    }

}
