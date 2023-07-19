package com.example.practice.config.domain.dto;

import com.example.practice.todos.domain.entity.Todo;
import lombok.Getter;

@Getter
public class TodoDto {
    private Long id;
    private String title;
    private String content;
    private boolean isDone;
    private Integer likeCount;
    public TodoDto(Todo todo){
        this.id = todo.getId();
        title = todo.getTitle();
        content = todo.getContent();
        isDone = todo.isDone();
        likeCount = todo.getLikeCount();
    }
}