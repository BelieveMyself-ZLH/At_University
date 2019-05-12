package com.zlh.core;

import com.zlh.crypto.Hash;
import com.zlh.utils.Encrypt;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @Author: ZhouLinHu
 * @Description: 区块Header
 * @Date: Created in 16:06 2019/4/13
 */
public class BlockHeader implements Serializable {
    //区块高度
    private Integer index;
    //难度指标
    private BigInteger difficulty;
    //PoW问题的答案，工作量证明
    private Long nonce;
    //时间戳
    private Long timestamp;
    //区块hash
    private String hash;
    //上一个区块的Hash
    private String previousHash;

    public BlockHeader(){ this.timestamp = System.currentTimeMillis();}
    public BlockHeader(Integer index, String previousHash){
        this.index = index;
        this.timestamp = System.currentTimeMillis();
        this.previousHash = previousHash;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BigInteger getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BigInteger difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "BlockHeader{" +
                "index=" + index +
                ", difficulty=" + difficulty +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                '}';
    }

    //获取区块头的hash值
    public String hash(){
        return Hash.sha3("BlockHeader{" +
                "index=" + index +
                ", difficulty=" + difficulty +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", previousHash='" + previousHash + '\'' +
                '}');
    }
}
