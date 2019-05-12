package com.zlh.mine.pow;

import com.zlh.core.Block;
import com.zlh.crypto.Hash;
import com.zlh.utils.ByteUtils;
import com.zlh.utils.Numeric;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

/**
 * @Author: ZhouLinHu
 * @Description: 工作量证明的实现
 * @Date: Created in 10:49 2019/4/15
 */
public class ProofOfWork {
    //难度指标
    public static final int TARGET_BITS = 12;
    //区块
    private Block block;
    //难度指标
    private BigInteger target;

    private ProofOfWork(Block block, BigInteger target){
        this.block = block;
        this.target = target;
    }

    public Block getBlock() {
        return block;
    }

    public static BigInteger getTarget() {
        return BigInteger.valueOf(1).shiftLeft((256-TARGET_BITS));
    }

    /**
     * 创建新的工作量证明，设定难度目标值
     * 对1进行移位运算，将1向左移动（256-TARGET_BITS）位，得到我们的难度目标值
     * @param block
     * @return
     */
    public static ProofOfWork newProofOfWork(Block block){
        BigInteger targetValue = BigInteger.valueOf(1).shiftLeft((256-TARGET_BITS));
        return new ProofOfWork(block, targetValue);
    }

    /**
     * 运行工作量证明，开始挖矿，找到小于难度目标值的Hash
     */
    public PowResult run(){
        long nonce = 0;
        String shaHex = "";
        while (nonce < Long.MAX_VALUE){
            byte[] data = this.prepareData(nonce);
            shaHex = Hash.sha3String(data);
            if (new BigInteger(shaHex,16).compareTo(this.target)==-1){
                break;
            }else {
                nonce++;
            }
        }
        return new PowResult(nonce, shaHex, this.target);
    }

    /**
     * 准备数据
     * 注意：在准备区块数据时，一定要从原始数据类型转化为byte[],不能直接从字符串进行转化
     */
    private byte[] prepareData(long nonce){
        byte[] prevBlockHashBytes = {};
        if (StringUtils.isNoneBlank(this.getBlock().getHeader().getPreviousHash())){
            //这里要去掉hash值的0x前缀，否者会抛出异常
            String prevHash = Numeric.cleanHexPrefix(this.getBlock().getHeader().getPreviousHash());
            prevBlockHashBytes = new BigInteger(prevHash, 16).toByteArray();
        }

        return ByteUtils.merge(
                prevBlockHashBytes,
                ByteUtils.toBytes(this.getBlock().getHeader().getTimestamp()),
                ByteUtils.toBytes(TARGET_BITS),
                ByteUtils.toBytes(nonce)
        );
    }

    //验证区块是否有效
    public boolean validate(){
        byte[] data = this.prepareData(this.getBlock().getHeader().getNonce());
        return new BigInteger(Hash.sha3String(data),16).compareTo(this.target) == -1;
    }
}
