package com.example.demo.store;

import com.example.demo.hobby.Hobby;
import com.example.demo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MemberHobby {
    private Member member;
    private Hobby hobby;

    public MemberHobby(Member member, Hobby hobby) {
        this.member = member;
        this.hobby = hobby;
        member.getHobbies().add(this);
        hobby.getMembers().add(this);
    }
}