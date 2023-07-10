package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;

import java.util.List;

public class HobbyService {

    public List<Hobby> findAll() {
        return Store.hobbies;
    }

}
