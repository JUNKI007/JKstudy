package com.example.practice.todos.request;

import com.example.practice.members.domain.entity.Member;
import com.example.practice.todos.domain.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private String content;
    private Long memberId;

    //request를 entity로 바꿔주겠다
    //builder를 써주는 이유는 new Todo(null, title, content, false, 0, member)이 아래 내용과 같은데 가독성 더 좋음
    public Todo toEntity(){
        Member member = Member.builder()
                .id(memberId)
                .build();

        return Todo.builder()
                .content(content)
                .title(title)
                .member(member)
                .likeCount(0)
                .build();
    }
}
