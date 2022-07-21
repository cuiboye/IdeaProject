package com.example.demo;

import java.util.List;

public class BaokuanzhijiangEntity<T> {
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
        private String startTime;
        private List<ContentList> list;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public List<ContentList> getList() {
            return list;
        }

        public void setList(List<ContentList> list) {
            this.list = list;
        }

        static class ContentList {
            private String imageUrl;
            private String productName;
            private String currentPrice;
            private String beforePrice;
            private String descript;
            private int type;
            private List<String> tags;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getImageUrl() {
               return imageUrl;
           }

           public void setImageUrl(String imageUrl) {
               this.imageUrl = imageUrl;
           }

           public String getProductName() {
               return productName;
           }

           public void setProductName(String productName) {
               this.productName = productName;
           }

           public String getCurrentPrice() {
               return currentPrice;
           }

           public void setCurrentPrice(String currentPrice) {
               this.currentPrice = currentPrice;
           }

           public String getBeforePrice() {
               return beforePrice;
           }

           public void setBeforePrice(String beforePrice) {
               this.beforePrice = beforePrice;
           }

           public String getDescript() {
               return descript;
           }

           public void setDescript(String descript) {
               this.descript = descript;
           }

           public List<String> getTags() {
               return tags;
           }

           public void setTags(List<String> tags) {
               this.tags = tags;
           }
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
