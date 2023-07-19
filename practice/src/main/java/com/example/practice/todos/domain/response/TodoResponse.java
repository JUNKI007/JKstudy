package com.example.practice.todos.domain.response;

import com.example.practice.config.domain.dto.MemberDto;
import com.example.practice.config.domain.dto.TodoDto;
import com.example.practice.todos.domain.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponse extends TodoDto {
    private MemberDto member;
    public TodoResponse(Todo todo){
        super(todo);
        member = new MemberDto(todo.getMember());
    }
}