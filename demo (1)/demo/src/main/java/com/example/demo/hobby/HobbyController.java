package com.example.demo.hobby;

import com.example.demo.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hobbies")
@RequiredArgsConstructor

public class HobbyController {
    
    //findAll해서 (Hobby)만 찾자
//[
//    {
//        name:"태경",
//                age: 21,
//            hobbies: [ {id: 1, name: "책보기"}]
//    },
//    {
//        name:"태열",
//                age: 21,
//            hobbies: [ {id: 2, name: "책보기", }, {id: 3, name: "이론공부", }]
//    }
//]

    @GetMapping
    public List<Hobby> findAll(){
        return HobbyService.findAll();
    }



}
