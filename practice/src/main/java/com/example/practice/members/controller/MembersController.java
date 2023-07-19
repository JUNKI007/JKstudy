package com.example.practice.members.controller;

import com.example.practice.members.domain.request.LoginRequest;
import com.example.practice.members.domain.request.SignupRequest;
import com.example.practice.members.domain.response.LoginResponse;
import com.example.practice.members.domain.response.MemberResponse;
import com.example.practice.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MembersController {

    private final MemberService service;
    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest loginRequest){
        return service.login(loginRequest);
    }
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(
            @RequestBody SignupRequest request){
        service.insert(request);
    }

    @GetMapping
    public Page<MemberResponse> getAll(
            @RequestParam(required = false, defaultValue = "0", name = "page")
            Integer page,
            @RequestParam(required = false, defaultValue = "3", name = "size")
            Integer size
    ){
//        if(member == null) init();
        return service.findAll(PageRequest.of(page, size));
    }

}