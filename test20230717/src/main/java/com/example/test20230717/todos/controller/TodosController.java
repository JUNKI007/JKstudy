package com.example.test20230717.todos.controller;

import com.example.test20230717.todos.domain.response.TodosResponse;
import com.example.test20230717.todos.entity.Todos;
import com.example.test20230717.todos.service.TodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodosController {
    private final TodosService todosService;

    @GetMapping
    public List<TodosResponse> getTodos(String content, int page, int size, String isDone) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Todos> todosPage;

        if (isDone != null) {
            todosPage = todosRepository.findByContentContainingAndIsDone(content, isDone, pageable);
        } else {
            todosPage = todosRepository.findByContentContaining(content, pageable);
        }

        List<Todos> todosList = todosPage.getContent();
        return todosList.stream()
                .map(TodosResponse::fromEntity)
                .collect(Collectors.toList());
    }

}
