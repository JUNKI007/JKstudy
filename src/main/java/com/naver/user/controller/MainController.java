package com.naver.user.controller;


import com.naver.user.domain.dto.HeartSupport;
import com.naver.user.domain.dto.Update;
import com.naver.user.domain.entity.NewTodoJoinUser;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.FindTodoRequest;
import com.naver.user.domain.request.UpdateRequest;
import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/map")
    public ModelAndView test(ModelAndView modelAndView){
        Map<String,String> map = new HashMap<>();
        map.put("a", "apple");
        map.put("b", "banana");
        modelAndView.addObject("keys",map.keySet());
        modelAndView.addObject("map",map);
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @GetMapping("/main")
    public ModelAndView showMain(
            @RequestParam(value = "keyword", required = false) String keyword
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todos/main");
//        if(keyword!= null && !keyword.equals("")){
//            List<TodoJoinUser> byKeyword = todoService.findByKeyword(keyword);
//            modelAndView.addObject("todolist", byKeyword);
//        }else{
//            //         투두 리스트 가져다 줘야하고
//            modelAndView.addObject("todolist", todoService.findAll());
//        }
        List<TodoJoinUser> byKeyword = todoService.findByKeyword(keyword);
        modelAndView.addObject("todolist", byKeyword);
        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView inputdata(
            @RequestParam("content") String content,
            ModelAndView mav,
            HttpSession session
    ){
        Integer id = (Integer) session.getAttribute("id");
        // TODO insert 서비스 에다가 만들거다.

        if(id != null) {
            try {
                todoService.insert(id, content);
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }
            mav.setViewName("redirect:/main");
        }
        else {
//            mav.setViewName("redirect:/main?err=not_insert");
            mav.setViewName("redirect:/main");
            mav.addObject("err", "not_insert");
        }
        return mav;

    }
    @GetMapping("/todo/update")
    public ModelAndView showUpdatePage(
            @RequestParam("todoid") String id,
            ModelAndView mav){

        mav.addObject("todoid",id);
        mav.setViewName("/todos/todoupdate");

        return  mav;
    }

    @PostMapping("/todo/update")
    public ModelAndView updateData(
            @ModelAttribute UpdateRequest updateRequest,
            HttpSession session,
            ModelAndView mav){

        int uid = (int) session.getAttribute("id");
        Update dto = updateRequest.toDto(uid);
//        Update update = new Update(
//                updateRequest.getId(),
//                uid,
//                updateRequest.getContent());

        todoService.update(dto);

        mav.setViewName("redirect:/main");

        return mav;

    }

    @PostMapping("/todo/like")
    public ModelAndView likeUpdate(
            @RequestParam("todoid") Integer todoid,
            HttpSession session,
            ModelAndView mav){

//        1 uid  2 tid  == > heart 테이블의 행 갯수 == 좋아요 갯수
//        FindTodoRequest request =new FindTodoRequest((Integer) session.getAttribute("id"), todoid, 0);
//        List<NewTodoJoinUser> result = todoService.findAllHearts();

//        tid 해당 게시글에 유저 id 있는지 조회
//        있으면 -1 없으면 +1
//        FindTodoRequest newRequest = new FindTodoRequest()
        HeartSupport heartSupport = new HeartSupport(
                (Integer) session.getAttribute("id"), todoid, null
        );
        try {
            todoService.clickHeart(heartSupport);
        } catch (Exception e) {

        }
        mav.setViewName("redirect:/main");
        return mav;

    }




}
