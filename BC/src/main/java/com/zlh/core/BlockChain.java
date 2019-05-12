package com.zlh.core;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.zlh.crypto.Credentials;
import com.zlh.crypto.Keys;
import com.zlh.crypto.Sign;
import com.zlh.db.IDBAccess;
import com.zlh.enums.TransactionStatusEnum;
import com.zlh.event.MineBlockEvent;
import com.zlh.event.SendTransactionEvent;
import com.zlh.mine.Miner;
import com.zlh.net.ApplicationContextProvider;
import com.zlh.net.base.Node;
import com.zlh.net.client.AppClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: ZhouLinHu
 * @Description: 区块链主类
 * @Date: Created in 8:42 2019/4/15
 */
@Component
public class BlockChain {


    private static Logger logger = LoggerFactory.getLogger(BlockChain.class);

    @Autowired
    private IDBAccess dbAccess;

    @Autowired
    private AppClient appClient;

    @Autowired
    private Miner miner;

    @Autowired
    private TransactionPool transactionPool;

    @Autowired
    private TransactionExecutor executor;


    /**
     * 挖取一个区块
     * @return
     */
    public Block mining() throws Exception {

        Optional<Block> lastBlock = getLastBlock();
        Block block = miner.newBlock(lastBlock);
        transactionPool.getTransactions().forEach(e -> block.getBody().addTransaction(e));
        executor.run(block);
        //清空交易池
        transactionPool.clearTransactions();
        //存储区块
        dbAccess.putLastBlockIndex(block.getHeader().getIndex());
        dbAccess.putBlock(block);
        logger.info("Find a New Block, {}", block);

        //触发挖矿事件，并等待其他节点确认区块
        ApplicationContextProvider.publishEvent(new MineBlockEvent(block));
        return block;
    }

    /**
     * 发送交易
     * @param credentials 交易发起者的凭证
     * @param to 交易接收者
     * @param amount
     * @param data 交易附言
     * @return
     * @throws Exception
     */
    public Transaction sendTransaction(Credentials credentials, String to, BigDecimal amount, String data) throws
            Exception {
        //校验付款和收款地址
        Preconditions.checkArgument(to.startsWith("0x"), "收款地址格式不正确");
        Preconditions.checkArgument(!credentials.getAddress().equals(to), "收款地址不能和发送地址相同");
        //构建交易对象
        Transaction transaction = new Transaction(credentials.getAddress(), to, amount);
        transaction.setPublicKey(Keys.publicKeyEncode(credentials.getEcKeyPair().getPublicKey().getEncoded()));
        transaction.setStatus(TransactionStatusEnum.APPENDING);
        transaction.setData(data);
        transaction.setTxHash(transaction.hash());
        //签名
        String sign = Sign.sign(credentials.getEcKeyPair().getPrivateKey(), transaction.toString());
        transaction.setSign(sign);
        //先验证私钥是否正确
        if (!Sign.verify(credentials.getEcKeyPair().getPublicKey(), sign, transaction.toString())) {
            throw new RuntimeException("私钥签名验证失败，非法的私钥");
        }
        //打包数据到交易池
        transactionPool.addTransaction(transaction);
        //触发交易事件，向全网广播交易，并等待确认
        ApplicationContextProvider.publishEvent(new SendTransactionEvent(transaction));
        return transaction;
    }

    /**
     * 获取最后一个区块
     * @return
     */
    public Optional<Block> getLastBlock() {
        return dbAccess.getLastBlock();
    }

    /**
     * 添加一个节点
     * @param ip
     * @param port
     * @return
     */
    public void addNode(String ip, int port) throws Exception {

        appClient.addNode(ip, port);
        Node node = new Node(ip, port);
        dbAccess.addNode(node);
    }
}
