package com.zlh.core;

import java.io.Serializable;

/**
 * @Author: ZhouLinHu
 * @Description: 区块
 * @Date: Created in 16:01 2019/4/13
 */
public class Block implements Serializable {
    //区块Header
    private BlockHeader header;
    //区块Body
    private BlockBody body;

    public Block(){}
    public Block(BlockHeader header, BlockBody body){
        this.header = header;
        this.body = body;
    }

    public BlockHeader getHeader() {
        return header;
    }

    public void setHeader(BlockHeader header) {
        this.header = header;
    }

    public BlockBody getBody() {
        return body;
    }

    public void setBody(BlockBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Block{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
