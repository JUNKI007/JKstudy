package com.example.test20230717.member.service;

import com.example.test20230717.exception.LoginFailedException;
import com.example.test20230717.member.domain.entity.Member;

import com.example.test20230717.member.domain.entity.MemberLogin;
import com.example.test20230717.member.domain.request.MemberRequest;
import com.example.test20230717.member.repository.MemberLoginRepository;
import com.example.test20230717.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
    private final EntityManager em;
    private final MemberRepository memberRepository;
    private final MemberLoginRepository memberLoginRepository;

    private List<Member> memberList = new ArrayList<>();

    // 회원가입
    public ResponseEntity<String> insert(MemberRequest request) {
        // 중복 검사
        List<Member> emailDuplicateMembers = memberList.stream()
                .filter(member -> member.getEmail().equals(request.getEmail()))
                .collect(Collectors.toList());

        if (!emailDuplicateMembers.isEmpty()) {
            // 중복된 멤버(회원)가 이미 존재하면 400(Bad Request) 상태 코드와 에러 메시지를 반환합니다.
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Member with the same email already exists");
        }

        Member member = request.toEntity();
        memberList.add(member);

        // 저장이 성공적으로 이루어졌음을 의미하므로 201(Created) 상태 코드와 성공 메시지를 반환합니다.
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Member created successfully");
    }

    // 로그인
    public ResponseEntity<String> login(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new LoginFailedException("Login failed: Member not found"));

        if (!member.getPassword().equals(password)) {
            throw new LoginFailedException("Login failed: Invalid email or password");
        }

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime endAt = createdAt.plusMinutes(10);

        // 로그인 세션 정보 저장
        MemberLogin memberLogin = new MemberLogin();
        memberLogin.setMemberId(member.getId());
        memberLogin.setCreatedAt(createdAt);
        memberLogin.setEndAt(endAt);
        memberLoginRepository.save(memberLogin);

        return ResponseEntity.ok("Login successful");
    }
}
