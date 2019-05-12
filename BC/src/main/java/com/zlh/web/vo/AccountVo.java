package com.zlh.web.vo;

import com.zlh.account.Account;

/**
 * @Author: ZhouLinHu
 * @Description: account Vo
 * @Date: Created in 14:22 2019/5/8
 */
public class AccountVo extends Account {
    private String privateKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "AccountVo{" +
                "address='" + getAddress() + '\'' +
                "privateKey='" + getPrivateKey() + '\'' +
                "balance='" + getBalance() + '\'' +
                '}';
    }
}
