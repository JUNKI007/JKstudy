package com.naver.user.domain.dto;

public class Keyword {
    private String keyword;
    private Integer uid;

    public Keyword(String keyword, Integer uid) {
        this.keyword = keyword;
        this.uid = uid;
    }

    public String getKeyword() {
        return keyword;
    }

    public Integer getUid() {
        return uid;
    }
}
