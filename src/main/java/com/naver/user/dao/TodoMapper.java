package com.naver.user.dao;

import com.naver.user.domain.entity.Todo;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoMapper {
    private final SqlSessionTemplate sessionTemplate;

    public TodoMapper(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    public List<TodoJoinUser> findAll() {
        return sessionTemplate.selectList("todo.findAll");
    }


    public List<TodoJoinUser> findByKeyword(String Keyword){
        return sessionTemplate.selectList("todo.findByKeyword",
                "%" + Keyword + "%");
    }


}