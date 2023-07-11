package com.example.demo.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<MemberResponse> findAll(){
        return memberService.findAll();
    }
    @GetMapping("{id}")
    public MemberResponse findById(@PathVariable("id") Integer id){
        return new MemberResponse(memberService.findById(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest member){
        memberService.save(member.toEntity());
    }
    @PutMapping("{id}")
    public MemberResponse update(@PathVariable("id") Integer id
            , @RequestBody MemberRequest request){
        return memberService.update(id, request);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id){
        memberService.deleteById(id);
    }
}