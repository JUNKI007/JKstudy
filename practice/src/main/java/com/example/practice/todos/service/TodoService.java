package com.example.practice.todos.service;

import com.example.practice.todos.repository.TodoRepository;
import com.example.practice.todos.request.TodoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public void insert(TodoRequest todoRequest){
        todoRepository.save(todoRequest.toEntity());
    }
}
