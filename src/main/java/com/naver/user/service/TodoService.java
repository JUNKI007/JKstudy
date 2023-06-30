package com.naver.user.service;

import com.naver.user.dao.HeartMapper;
import com.naver.user.dao.TodoDao;
import com.naver.user.dao.TodoMapper;
import com.naver.user.dao.TodoMapper2;
import com.naver.user.domain.dto.HeartSupport;
import com.naver.user.domain.dto.Update;
import com.naver.user.domain.entity.NewTodoJoinUser;
import com.naver.user.domain.entity.TodoJoinUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;
    private final TodoMapper2 todoMapper;
    private final HeartMapper heartMapper;

    public TodoService(TodoDao todoDao, TodoMapper2 todoMapper,HeartMapper heartMapper) {
        this.todoDao = todoDao;
        this.todoMapper = todoMapper;
        this.heartMapper = heartMapper;
    }

    public List<TodoJoinUser> findAll(){
        return todoMapper.findAll();
    }

    public int insert(Integer uid, String content){
        //Dao 에 있는 기능을 끌어올 예정.
        return todoDao.insert(uid,content);

    }
    public List<TodoJoinUser> findByKeyword(String keyword){
        if(keyword != null) keyword = "%"+keyword+"%";
        return todoMapper.findByKeyword(keyword);
//        todoDao.findByKeyword(keyword);
    }

    public int update(Update update){
        return todoMapper.update(update);
    }

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
