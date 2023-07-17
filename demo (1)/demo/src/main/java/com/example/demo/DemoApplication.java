package com.example.demo;

import com.example.demo.hobby.Hobby;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRequest;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
//		Member 김수동 = new Member("김수동", 23);
//		Store.members.add(김수동);
//		Hobby hobby = new Hobby(null, "축구", null);
//		Store.hobbies.add(hobby);
//		new MemberHobby(김수동,hobby);
	}
}