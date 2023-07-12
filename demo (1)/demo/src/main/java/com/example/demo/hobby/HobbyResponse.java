package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.MemberHobby;
import lombok.Getter;

import java.util.List;

@Getter
public class HobbyResponse {
    private Integer id;
    private String name;
    private List<MemberDto> members;

    public HobbyResponse(Hobby hobby) {
        this.id = hobby.getId();
        this.name = hobby.getName();
        this.members = hobby.getMembers()
                .stream()
//                .map(mb -> new MemberDto(mb.getMember()))
                .map(MemberHobby::getMember)
//                .map(m-> new MemberDto(m))
                .map(MemberDto::new)
                .toList();
    }

    @Getter
    class MemberDto{
        private Integer id;
        private String name;
        private Integer age;

        public MemberDto(Member member) {
            this.id = member.getId();
            this.name = member.getName();
            this.age = member.getAge();
        }
    }
}