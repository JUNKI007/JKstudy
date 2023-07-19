package com.example.practice.todos.service;

import com.example.practice.config.service.MemberLoginService;
import com.example.practice.todos.repository.TodoRepository;
import com.example.practice.todos.domain.request.TodoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final MemberLoginService memberLoginService;
    public void insert(TodoRequest request){
        memberLoginService.findByMember(request.getMemberId());
        todoRepository.save(request.toEntity());
    }
}