package com.zlh.db;

import com.google.common.base.Optional;
import com.zlh.account.Account;
import com.zlh.core.Block;
import com.zlh.net.base.Node;

import java.util.List;


/**
 * @Author: ZhouLinHu
 * @Description: 数据库操作接口方法封装
 * @Date: Created in 14:05 2019/4/13
 */
public interface IDBAccess {
//    //保存区块链blockchain
//    boolean putBlockChain(List<Block> blockchain);
//    //读取区块链blockchain
//    List<Block> getBlockChain();

    //1、更新最新的一个区块的Hash值
    boolean putLastBlockIndex(Object lastBlock);
    //2、获取最新一个区块的Hash值
    Optional<Object> getLastBlockIndex();
    //3、保存区块
    boolean putBlock(Block block);
    //4、获取指定的区块，根据区块高度去获取
    Optional<Block> getBlock(Object blockIndex);
    //5、获取最后（最大高度）一个区块
    Optional<Block> getLastBlock();
    //6、添加一个钱包账户
    boolean putAccount(Account account);
    //7、获取指定的钱包账户
    Optional<Account> getAccount(String address);
    //8、设置挖矿账户
    boolean putCoinBaseAddress(String address);
    //9、获取挖矿账户地址
    Optional<String> getCoinBaseAddress();
    //10、获取挖矿账户
    Optional<Account> getCoinBaseAccount();
    //11、设置挖矿账户
    boolean putCoinBaseAccount(Account account);
    //12、获取客户端节点列表
    Optional<List<Node>> getNodeList();
    //13、保存客户端节点列表
    boolean putNodeList(List<Node> nodes);
    //14、添加一个客户端节点
    boolean addNode(Node node);
    //15、清空所有节点
    void clearNodes();
    //16、往数据库添加/更新一条数据
    boolean put(String key, Object value);
    //17、获取某一条指定的数据
    Optional<Object> get(String key);
    //18、删除一条数据
    boolean delete(String key);
    //19、根据前缀搜索
    <T>List<T> seekByKey(String keyPrefix);
    //20、获取账户列表
    List<Account> listAccounts();
    //21、关闭数据库
    void closeDB();
}
