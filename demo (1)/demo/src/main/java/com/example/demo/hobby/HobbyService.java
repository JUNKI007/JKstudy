package com.example.demo.hobby;


import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyService {
    private final MemberService memberService;
    public void save(HobbyRequest request){
        Member byId = memberService.findById(request.getMemberId());
        Hobby hobby = new Hobby(null, request.getName(), byId);
        Store.hobbies.add(hobby);
        byId.getHobbies().add(hobby);
    }
//    public List<Hobby> findAll(){
//        return h
//    }
}