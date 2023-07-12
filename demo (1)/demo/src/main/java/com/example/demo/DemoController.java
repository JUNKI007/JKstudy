package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class DemoController {

    List<User> userList = new ArrayList<>();

    public DemoController() {
        userList.add(new User("김수동", 29));
        userList.add(new User("이세인", 25));
        userList.add(new User("이태웅", 26));
        userList.add(new User("정민균", 28));
    }

    @GetMapping
    public List<User> test() throws InterruptedException {
        return userList;
    }

    @GetMapping("{name}")
    public User findByName(@PathVariable("name") String name) {
        //name이라는 경로 변수를 String 타입의 name 매개변수로 받아옵니다. 이 메서드는 User 객체를 반환합니다.
        //User는 클래스로, User 클래스의 인스턴스인 객체를 찾아 반환하는 것이 findByName 메소드의 역할입니다.
        //@PathVariable은 Spring MVC에서 사용되는 어노테이션으로, RESTful API의 경로 변수를 매핑하는데 사용
        //RESTful API에서 경로 변수는 URL 경로에 포함된 변수입니다. 예를 들어, "/users/{id}"와 같은 URL 패턴에서 "{id}"는 경로 변수입니다.

        return userList
                .stream()
                //userList 컬렉션을 스트림으로 변환하는 역할을 합니다. (userLisT는 User를 담고있음)
                .filter(u -> u.getName().equals(name))
                .findFirst()
                //필터링된 첫 번째 요소를 반환합니다.
                .orElse(null);
    }


//    @PostMapping
//    public void insert(@RequestBody User user){
//        //User는 클래스입니다. user는 변수명으로서 User 클래스의 인스턴스인 객체를 참조하는 변수입니다.
//        userList.add(user);
//    }

    @PostMapping
    @RequestMapping
    public ResponseEntity insert(@RequestBody User user) {
        //ResponseEntity는 Spring Framework에서 HTTP 응답을 나타내는 클래스
        userList.add(user);
        // 만약 user가 있으면 200
        // 없으면 201
        User user1 = userList
                .stream()
                .filter(u -> u.getName().equals(user.getName()))
                .findFirst()
                .orElse(null);

        if (user1 == null) {
            userList.add(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        }
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable("name") String name){
            userList.stream().filter(u-> !u.getName().equals(name))
                    .toList();
        }



    @PutMapping("{name}")
    public void update(
            @PathVariable("name") String name,
            @RequestBody User user
            ) {
            userList.stream()
                    .map(u->
                            u.getName().equals(name) ? new User(name, u.getAge()): u)
                    .toList();

    }
}




//    *ResponseStatus 하는법
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity insert(@RequestBody User user) {
//        //ResponseEntity는 Spring Framework에서 HTTP 응답을 나타내는 클래스
//        userList.add(user);
//        // 만약 user가 있으면 200
//        // 없으면 201
//        User user1 = userList
//                .stream()
//                .filter(u -> u.getName().equals(user.getName()))
//                .findFirst()
//                .orElse(null);
//
//        if (user1 == null) {
//            userList.add(user);
////            return ResponseEntity
////                    .status(HttpStatus.CREATED)
////                    .build();
//        }else{
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .build();
//        }
//    }


//View를 내보내지 않고 Data만 보내고 싶을때는 Responsebody
//Responsebody + Controller = Restcontroller
//* Rest = responsebody

//Restfull
//1. 바디를 리턴하면 화면이 없다 (클라이너트- 서버구조)
//2. 무상태(stateless) 클라이언트 전에 요청을 기억하고 있지 않다.
//3. 대답을 계속하니까 힘들어서 캐시를 사용해라
//4. 계층화된 시스템 . 시스템의 구성요소를 분리하여 독립적으로 관리(m -> c)
//5. 유니폼 인터페이스 (80%는 사용하지 않음 -> 서버가 주축이 되어서 다음 페이지를 정해줘야한다.)
//      내가 유저를 insert함 -> 서버는 user를 지우거나 수정하는 방법을 정해줘야함



// 참고자료 : https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/GET
//Rest api
//Get : body가 없다. http://localhost?name=fgttjh&age=20 , 데이터를 Get
//Post : body가 있다. http://localhost, 데이터를 insert
//Put : 데이터를 Update
//Del : 데이터를 delete

