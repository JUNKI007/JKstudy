package com.naver.user.service;

import com.naver.user.dao.TodoDao;
import com.naver.user.dao.TodoMapper;
import com.naver.user.domain.entity.TodoJoinUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;
    private final TodoMapper todoMapper;

    public TodoService(TodoDao todoDao, TodoMapper todoMapper) {
        this.todoDao = todoDao;
        this.todoMapper = todoMapper;
    }

    public List<TodoJoinUser> findAll(){
        return todoMapper.findAll();
    }

    public int insert(Integer uid, String content){
        //Dao 에 있는 기능을 끌어올 예정.
        return todoDao.insert(uid,content);

    }
    public List<TodoJoinUser> findByKeyword(String keyword){

        return null;
//        todoDao.findByKeyword(keyword);
    }
}