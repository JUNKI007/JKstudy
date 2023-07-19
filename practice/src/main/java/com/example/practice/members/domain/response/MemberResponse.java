package com.example.practice.members.domain.response;

import com.example.practice.config.domain.dto.MemberDto;

import com.example.practice.config.domain.dto.TodoDto;
import com.example.practice.members.domain.entity.Member;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberResponse extends MemberDto {
    private List<TodoDto> todos;

    public MemberResponse(Member member) {
        super(member);
        todos = member.getTodos()
                .stream()
                .map(TodoDto::new)
                .toList();
//            todos = new ArrayList<>();

    }
}