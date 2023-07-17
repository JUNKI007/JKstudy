package com.example.demo.hobby;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hobbies")
@RequiredArgsConstructor
public class HobbyController {
    private final HobbyService service;
    @PostMapping
    public void save(@RequestBody HobbyRequest request){
        service.save(request);
    }
    @PostMapping("/connect")
    public void save(@RequestBody ConnectRequest request){
        service.connect(request);
    }
    @GetMapping
    public List<HobbyResponse> getHobbyList(
            @RequestParam(value = "name"
                    , required = false
                    , defaultValue = "") String name){
        System.out.println(name);
        return service.findByLikeName(name);
    }




}