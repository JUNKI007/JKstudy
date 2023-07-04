package com.naver.user.service;

import com.naver.user.dao.HeartMapper;
import com.naver.user.dao.TodoDao;
import com.naver.user.dao.TodoMapper2;
import com.naver.user.domain.dto.HeartSupport;
import com.naver.user.domain.dto.Update;
import com.naver.user.domain.entity.NewTodoJoinUser;
import com.naver.user.domain.entity.TodoJoinUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;
    private final TodoMapper2 todoMapper;
    private final HeartMapper heartMapper;
    private List<TodoJoinUser> list;
    public TodoService(TodoDao todoDao, TodoMapper2 todoMapper,HeartMapper heartMapper
            ) {
        this.todoDao = todoDao;
        this.todoMapper = todoMapper;
        this.heartMapper = heartMapper;
    }
    public List<TodoJoinUser> findAll(){
        return todoMapper.findAll();
    }

    public int insert(Integer uid, String content){
        //Dao 에 있는 기능을 끌어올 예정.
        int insert = todoDao.insert(uid, content);
        list = null;
        return insert;

    }
    public List<TodoJoinUser> findByKeyword(String keyword){
        long start = new Date().getTime();
        if(list == null && keyword == null){
            list = todoMapper.findByKeyword(keyword);
        }
        if(keyword != null) {
            keyword = "%" + keyword + "%";
            List<TodoJoinUser> byKeyword = todoMapper.findByKeyword(keyword);
            System.out.println(new Date().getTime() - start + " ms");
            return byKeyword;
        }
        System.out.println(new Date().getTime() - start + " ms");
        return list;
    }

    public int update(Update update){
        return todoMapper.update(update);
    }

    @Transactional
    public void clickHeart(HeartSupport heartSupport) throws Exception {
        int result = heartMapper.findById(heartSupport);
        heartSupport.setResult(result);
        heartMapper.updateHearts(heartSupport);
        if(heartSupport.getTid() == 3) throw new Exception("");
        todoMapper.updateHearts(heartSupport);
    }






    public List<NewTodoJoinUser> findAllHearts(){
        return todoMapper.findAllHearts();
    }
}
