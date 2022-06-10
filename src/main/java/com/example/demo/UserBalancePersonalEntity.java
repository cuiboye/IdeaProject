package com.example.demo;

import java.util.List;

/**
 * 个人账户信息
 */
public class UserBalancePersonalEntity<T> {
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
        private String canUserMoney;
        private List<ListBankCardBean> listBankCard;
        private List<ListZhifubaoListBean> listZhifubaoListBeans;

        public List<ListZhifubaoListBean> getListZhifubaoListBeans() {
            return listZhifubaoListBeans;
        }

        public void setListZhifubaoListBeans(List<ListZhifubaoListBean> listZhifubaoListBeans) {
            this.listZhifubaoListBeans = listZhifubaoListBeans;
        }

        public List<ListBankCardBean> getListBankCard() {
            return listBankCard;
        }

        public void setListBankCard(List<ListBankCardBean> listBankCard) {
            this.listBankCard = listBankCard;
        }

        public String getCanUserMoney() {
            return canUserMoney;
        }

        public void setCanUserMoney(String canUserMoney) {
            this.canUserMoney = canUserMoney;
        }

        public static class ListBankCardBean{
            private String bankName;
            private String bankCardNumber;
            private String ownerName;

            public String getOwnerName() {
                return ownerName;
            }

            public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getBankCardNumber() {
                return bankCardNumber;
            }

            public void setBankCardNumber(String bankCardNumber) {
                this.bankCardNumber = bankCardNumber;
            }
        }

        public static class ListZhifubaoListBean{
            private String zhifubaoZhanghao;
            private String zhifubaoUserName;

            public String getZhifubaoZhanghao() {
                return zhifubaoZhanghao;
            }

            public void setZhifubaoZhanghao(String zhifubaoZhanghao) {
                this.zhifubaoZhanghao = zhifubaoZhanghao;
            }

            public String getZhifubaoUserName() {
                return zhifubaoUserName;
            }

            public void setZhifubaoUserName(String zhifubaoUserName) {
                this.zhifubaoUserName = zhifubaoUserName;
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
