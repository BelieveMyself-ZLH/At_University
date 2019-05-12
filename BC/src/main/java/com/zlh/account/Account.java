package com.zlh.account;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: ZhouLinHu
 * @Description: 钱包账户
 * @Date: Created in 15:42 2019/4/13
 */
public class Account implements Serializable {
    //钱包地址
    protected String address;
    //账户余额
    protected BigDecimal balance;

    public Account(){}
    public Account(String address, BigDecimal balance){
        this.address = address;
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "address='" + address + '\'' +
                ", balance=" + balance +
                '}';
    }
}
