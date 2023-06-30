package com.naver.user.domain.dto;

public class HeartSupport {
    private Integer uid;
    private Integer tid;
    private Integer result;

    public HeartSupport(Integer uid, Integer tid, Integer result) {
        this.uid = uid;
        this.tid = tid;
        this.result = result;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
