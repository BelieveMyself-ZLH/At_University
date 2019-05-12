package com.zlh.web.vo;

import java.math.BigDecimal;

/**
 * @Author: ZhouLinHu
 * @Description: 发送交易参数
 * @Date: Created in 14:23 2019/5/8
 */
public class TransactionVo {
    /**
     * 付款人地址
     */
    private String from;
    /**
     * 收款人地址
     */
    private String to;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 付款人私钥
     */
    private String privateKey;
    /**
     * 附加数据
     */
    private String data;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
