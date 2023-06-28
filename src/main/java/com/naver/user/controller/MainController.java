package com.naver.user.controller;


import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/main")
    public ModelAndView showMain(
            @RequestParam(value = "keyword", required = false) String keyword
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todos/main");
        if(keyword!= null && !keyword.equals("")){
            List<TodoJoinUser> byKeyword = todoService.findByKeyword(keyword);
            modelAndView.addObject("todolist", byKeyword);
        }else{
            //         투두 리스트 가져다 줘야하고
            modelAndView.addObject("todolist", todoService.findAll());
        }
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

        if(id != null && todoService.insert(id,content) != 0)
            mav.setViewName("redirect:/main");
        else {
//            mav.setViewName("redirect:/main?err=not_insert");
            mav.setViewName("redirect:/main");
            mav.addObject("err", "not_insert");
        }
        return mav;

    }
}