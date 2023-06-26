package com.naver.user.service;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService() {
        System.out.println("----------------- UserService--------------");
    }

    int count = 0;
    public int test(){
        count++;
        return count;
    }
    @Bean
    public int getCount(){
        System.out.println("----------------- get Count --------------");
        count++;
        return 1000;
    }

}