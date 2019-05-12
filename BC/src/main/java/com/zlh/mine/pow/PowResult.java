package com.zlh.mine.pow;

import java.math.BigInteger;

/**
 * @Author: ZhouLinHu
 * @Description: PoW计算结果
 * @Date: Created in 11:06 2019/4/15
 */
public class PowResult {
    //计数器
    private Long nonce;
    //Hash值
    private String hash;
    //目标难度值
    private BigInteger target;

    public PowResult(long nonce, String hash, BigInteger target){
        this.nonce = nonce;
        this.hash = hash;
        this.target = target;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BigInteger getTarget() {
        return target;
    }

    public void setTarget(BigInteger target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "PowResult{" +
                "nonce=" + nonce +
                ", hash='" + hash + '\'' +
                ", target=" + target +
                '}';
    }
}
