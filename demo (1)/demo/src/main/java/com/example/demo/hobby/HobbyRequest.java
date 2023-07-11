package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.member.MemberService;

public class HobbyRequest {
    private final String name;
    private final Integer memberId;

    public HobbyRequest(String name, Integer memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public Integer getMemberId() {
        return memberId;
    }
}