package com.zlh.web.controllers;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.zlh.account.Account;
import com.zlh.account.Personal;
import com.zlh.conf.Settings;
import com.zlh.core.Block;
import com.zlh.core.BlockChain;
import com.zlh.core.Transaction;
import com.zlh.crypto.Credentials;
import com.zlh.crypto.ECKeyPair;
import com.zlh.crypto.Keys;
import com.zlh.db.IDBAccess;
import com.zlh.utils.JsonVo;
import com.zlh.web.vo.AccountVo;
import com.zlh.web.vo.TransactionVo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhouLinHu
 * @Description: action响应控制器
 * @Date: Created in 21:15 2019/5/9
 */
@Controller
public class ActionController {
    @Autowired
    private IDBAccess idbAccess;
    @Autowired
    private Personal personal;
    @Autowired
    private BlockChain blockChain;
    @Autowired
    private Settings settings;

    private Logger logger = LoggerFactory.getLogger(ActionController.class);
    //获取以有账户列表信息
    @GetMapping("table1.g")
    @ResponseBody
    public String getAccountList(){
        List<Account> accounts = idbAccess.listAccounts();
        logger.info("账户："+accounts);
        JSONArray jsonArray = new JSONArray(accounts);
        return jsonArray.toString();
    }

    //实现新建账户功能的
    @PostMapping("newAc.p")
    @ResponseBody
    public String newAccount() throws Exception {
        ECKeyPair keyPair = Keys.createEcKeyPair();
        Account account = personal.newAccount(keyPair);
        AccountVo vo = new AccountVo();
        BeanUtils.copyProperties(account, vo);
        vo.setPrivateKey(keyPair.exportPrivateKey());
        List<AccountVo> list = new ArrayList<>();
        list.add(vo);
        JSONArray jsonArray = new JSONArray(list);
        return jsonArray.toString();
    }

    //获得整个区块链
    @GetMapping("blockchain.g")
    @ResponseBody
    public String getBlockChain(){
        List<Block> list = new ArrayList<>();
        for (int i=1;i<=(Integer) idbAccess.getLastBlockIndex().get();i++){
            list.add(idbAccess.getBlock(i).get());
        }
        JSONArray jsonArray = new JSONArray(list);
        return jsonArray.toString();
    }

    //获得最后一个区块
    @GetMapping("lastblack.g")
    @ResponseBody
    public String getLastBlock(){
        Optional<Block> lastBlock = idbAccess.getLastBlock();
        logger.info(lastBlock.get().toString());
        List<Block> list = new ArrayList<>();
        if(lastBlock.isPresent()){
            list.add(lastBlock.get());
        }
        JSONArray json = new JSONArray(list);
        return json.toString();
    }

    //挖矿
    @GetMapping("mine.g")
    @ResponseBody
    public String mine() throws Exception{
        Block block = blockChain.mining();

        List<Block> list = new ArrayList<>();
        list.add(block);
        JSONArray jsonArray = new JSONArray(list);
        return jsonArray.toString();
    }

//    发送交易
    @PostMapping("transaction.p")
    public String sendTransaction(@RequestParam("from") String from,
                                  @RequestParam("to") String to,
                                  @RequestParam("amount") int amount,
                                  @RequestParam("privateKey") String privateKey,
                                  @RequestParam("data") String data, Model model) throws Exception{
        TransactionVo txVo = new TransactionVo();
        txVo.setFrom(from);
        txVo.setTo(to);
        txVo.setAmount(BigDecimal.valueOf(amount));
        txVo.setPrivateKey(privateKey);
        txVo.setData(data);
        Preconditions.checkNotNull(txVo.getTo(), "Recipient is needed.");
        Preconditions.checkNotNull(txVo.getAmount(), "Amount is needed.");
        Preconditions.checkNotNull(txVo.getPrivateKey(), "Private Key is needed.");
        Credentials credentials = Credentials.create(txVo.getPrivateKey());
        Transaction transaction = blockChain.sendTransaction(
                credentials,
                txVo.getTo(),
                txVo.getAmount(),
                txVo.getData());

        //如果开启了自动挖矿，则直接自动挖矿
        if (settings.isAutoMining()) {
            blockChain.mining();
        }

//        //封装一个JSONVO对象
//        JsonVo jsonVo = new JsonVo();
//        jsonVo.setCode(JsonVo.CODE_SUCCESS);
//        jsonVo.setItem(transaction);
//        List<JsonVo> list = new ArrayList<>();
//        list.add(jsonVo);
//        JSONArray jsonArray = new JSONArray(list);
//        return jsonArray.toString();
        return "newAccount.html";
    }
}
