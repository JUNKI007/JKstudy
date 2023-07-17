package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.MemberHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemberResponse {
    private Integer id;
    private String name;
    private Integer age;
    private List<HobbyDto> hobbies = new ArrayList<>();
    public MemberResponse(Member member){
        this.id = member.getId();
        this.age = member.getAge();
        this.name = member.getName();
//        List<Hobby> hobbies = member.getHobbies();
//        for (int i = 0; i < hobbies.size(); i++) {
//            HobbyDto hobby = new HobbyDto(hobbies.get(i).getId()
//                    , hobbies.get(i).getName());
//            this.hobbies.add(hobby);
//        }
        this.hobbies = member.getHobbies()
                .stream()
                .map(MemberHobby::getHobby)
                .map(HobbyDto::new)
                .toList();

    }
    @Getter @AllArgsConstructor @NoArgsConstructor
    public class HobbyDto{
        private Integer id;
        private String name;
        public HobbyDto(Hobby hobby){
            this.id = hobby.getId();
            this.name = hobby.getName();
        }
        public HobbyDto toDto(Hobby hobby){
            return new HobbyDto(hobby.getId(), hobby.getName());
        }
    }
}