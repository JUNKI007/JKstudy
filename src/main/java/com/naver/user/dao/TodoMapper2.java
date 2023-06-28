package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;

import java.util.List;

public interface TodoMapper2 {
    List<TodoJoinUser> findAll();
}
