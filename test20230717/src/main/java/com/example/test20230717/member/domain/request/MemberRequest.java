package com.example.test20230717.member.domain.request;

import com.example.test20230717.member.domain.entity.Member;
import lombok.Data;

@Data
public class MemberRequest {
    private String email;
    private String password;
    private String name;
    private Integer age;

    public Member toEntity(){
        return Member
                .builder()
                .email(email)
                .password(password)
                .name(name)
                .age(age)
                .build();
    }
}
