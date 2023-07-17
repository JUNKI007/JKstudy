package com.example.demo.hobby;


import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.MemberHobby;
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
//        Member byId = memberService.findById(request.getMemberId());
        Hobby hobby = new Hobby(null, request.getName());
        Store.hobbies.add(hobby);
//        byId.getHobbies().add(hobby);
    }
    public void connect(ConnectRequest request){
        Member member = memberService.findById(request.memberId());
        Hobby hobby = Store.hobbies
                .stream()
                .filter(h-> h.getId().equals(request.hobbyId()))
                .findFirst()
                .get();
        new MemberHobby(member, hobby);
    }

    public List<HobbyResponse> findByLikeName(String name){
        return Store.hobbies.stream()
                .filter(h -> h.getName().contains(name))
                .map(h -> new HobbyResponse(h))
                .toList();
    }


}