package com.example.demo.exception;
public class MemberNotFound extends NullPointerException{
    private String api;
    private Integer memberId;
    public String getApi() {
        return api;
    }
    public void setApi(String api) {
        this.api = api;
    }
    public Integer getMemberId() {
        return memberId;
    }
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public MemberNotFound(String s, String api, Integer memberId) {
        super(s);
        this.api= api;
        this.memberId = memberId;
    }
}