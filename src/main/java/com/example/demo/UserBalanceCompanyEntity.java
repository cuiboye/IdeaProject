package com.example.demo;

import java.util.List;

/**
 * 公司账户信息
 */
public class UserBalanceCompanyEntity<T> {
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
        private List<ListCompanyVOBean> listCompanyVO;
        private List<ListBankCardBean> listBankCard;

        public List<ListBankCardBean> getListBankCard() {
            return listBankCard;
        }

        public void setListBankCard(List<ListBankCardBean> listBankCard) {
            this.listBankCard = listBankCard;
        }

        public List<ListCompanyVOBean> getListCompanyVO() {
            return listCompanyVO;
        }

        public void setListCompanyVO(List<ListCompanyVOBean> listCompanyVO) {
            this.listCompanyVO = listCompanyVO;
        }

        public static class ListCompanyVOBean{
            private String name;
            private String balance;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }
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
