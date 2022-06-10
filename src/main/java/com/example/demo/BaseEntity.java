package com.example.demo;

import java.util.List;

public class BaseEntity<T> {
    private String msg;
    public Result result;
    private int states;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    static class Result{
        private List<UserEntity> userList;

        public List<UserEntity> getUserList() {
            return userList;
        }

        public void setUserList(List<UserEntity> userList) {
            this.userList = userList;
        }
    }
    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

}
