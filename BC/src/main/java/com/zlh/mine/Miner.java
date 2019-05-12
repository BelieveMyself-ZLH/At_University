package com.zlh.mine;

import com.google.common.base.Optional;
import com.zlh.core.Block;

import java.math.BigDecimal;

/**
 * @Author: ZhouLinHu
 * @Description: 挖矿接口
 * @Date: Created in 9:57 2019/4/15
 */
public interface Miner {
    //挖矿奖励
    BigDecimal MINING_REWARD = BigDecimal.valueOf(50);
    //创始区块难度值
    Long GENESIS_BLOCK_NONCE = 100000L;

    //挖出一个新的区块
    Block newBlock(Optional<Block> block) throws Exception;

    //检验一个区块
    boolean validateBlock(Block block);
}
