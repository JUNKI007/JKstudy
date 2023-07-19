package com.example.practice.todos.domain.entity;

import com.example.practice.members.domain.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Table(name = "todos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Builder
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private boolean isDone;
    private Integer likeCount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}