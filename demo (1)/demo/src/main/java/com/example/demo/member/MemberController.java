package com.example.demo.member;


import com.example.demo.User;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
//서버를 만들어줄때는 api라고하고 뒤에는 버전을 붙여준다.
//그리고 뒤에 member였으면 members, user였으면 users로 복수로 받는것이 좋다
public class MemberController {



//    @Autowired
    private final MemberService memberService;




    @GetMapping
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("{id}")
    public Member findById(@PathVariable("id") Integer id){
        return memberService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest member){
        memberService.save(member.toEntity());
    // 왜 MemberRequest를 따로 만들었나?
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id){
        memberService.deleteById(id);
    }

    @PutMapping("{id}")
    public Member update(@PathVariable("id") Integer id
                         , @RequestBody MemberRequest request) {
        return memberService.update(id, request);
    }

}
