package com.example.demo.member;

import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public List<Member> findAll() {
        return Store.members;
    }


    public Member findById(Integer id) {
        for (int i = 0; i < Store.members.size(); i++) {

            if (Store.members.get(i).getId() == id)
                return Store.members.get(i);
        }

        return null;
    }

    public void save(Member member) {
        Store.members.add(member);
    }

    public void deleteById(Integer id) {
        Store.members.remove(findById(id));
    }

    public Member update(Integer id, MemberRequest request) {
        Member byId = findById(id);
        byId.setAge(request.age());
        byId.setName(request.name());
        return byId;
    }
}