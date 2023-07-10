package com.example.demo.member;


import lombok.*;

public record MemberRequest(String name, Integer age) {
    public Member toEntity(){
        return new Member(name, age);
    }
}
