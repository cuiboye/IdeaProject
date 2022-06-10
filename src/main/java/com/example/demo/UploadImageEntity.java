package com.example.demo;

import java.util.List;

public class UploadImageEntity<T> {
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
        private List<String> filePath;

        public List<String> getFilePath() {
            return filePath;
        }

        public void setFilePath(List<String> filePath) {
            this.filePath = filePath;
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
