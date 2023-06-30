package com.naver.user.domain.request;

public class FindTodoRequest {
    private int uid;
    private int tid;
    private int result;

    public FindTodoRequest(int uid, int tid, int result) {
        this.uid = uid;
        this.tid = tid;
        this.result = result;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public FindTodoRequest() {
    }
}
