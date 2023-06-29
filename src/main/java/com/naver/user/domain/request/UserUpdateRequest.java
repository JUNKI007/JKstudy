package com.naver.user.domain.request;

import com.naver.user.domain.dto.Update;
import com.naver.user.domain.dto.UserUpdate;

public class UserUpdateRequest {
    private String password;
    private String name;

    public UserUpdate toDto(int id){
        return new UserUpdate(id,password,name);
    }

    public UserUpdateRequest(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
