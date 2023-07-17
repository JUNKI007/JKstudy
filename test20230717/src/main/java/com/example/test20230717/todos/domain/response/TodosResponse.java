package com.example.test20230717.todos.domain.response;

import com.example.test20230717.member.domain.entity.Member;
import com.example.test20230717.todos.entity.Todos;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodosResponse {
    private Long id;
    private String title;
    private String content;
    private String isDone;
    private String likeCount;
    private Member member;

    public static TodosResponse fromEntity(Todos todos) {
        return new TodosResponse(
                todos.getId(),
                todos.getTitle(),
                todos.getContent(),
                todos.getIsDone(),
                todos.getLikeCount(),
                todos.getMember()
        );
    }
}
