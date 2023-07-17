package com.example.test20230717.todos.service;

import com.example.test20230717.todos.entity.Todos;
import com.example.test20230717.todos.repository.TodosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodosService {
    private final TodosRepository todosRepository;

    public List<Todos> getTodos(String content, int page, int size, String isDone) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Todos> todosPage;

        if (isDone != null) {
            todosPage = todosRepository.findByContentContainingAndIsDone(content, isDone, pageable);
        } else {
            todosPage = todosRepository.findByContentContaining(content, pageable);
        }

        return todosPage.getContent();
    }
}
