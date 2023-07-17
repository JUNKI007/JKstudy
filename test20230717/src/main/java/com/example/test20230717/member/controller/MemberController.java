package com.example.test20230717.member.controller;

import com.example.test20230717.exception.LoginFailedException;
import com.example.test20230717.member.domain.request.LoginRequest;
import com.example.test20230717.member.domain.request.MemberRequest;
import com.example.test20230717.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService service;

    // 회원가입
    @PostMapping
    public ResponseEntity<String> insert(@RequestBody MemberRequest request) {
        return service.insert(request);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            service.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (LoginFailedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
