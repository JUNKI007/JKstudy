package com.example.demo.member;



public record MemberRequest(String name, Integer age) {
    public Member toEntity(){
        return new Member(name, age);
    }
}