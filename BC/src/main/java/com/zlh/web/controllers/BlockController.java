package com.zlh.web.controllers;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.zlh.conf.Settings;
import com.zlh.core.Block;
import com.zlh.core.BlockChain;
import com.zlh.core.Transaction;
import com.zlh.crypto.Credentials;
import com.zlh.db.IDBAccess;
import com.zlh.net.base.Node;
import com.zlh.utils.JsonVo;
import com.zlh.web.vo.TransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhouLinHu
 * @Description: 区块链操作控制器
 * @Date: Created in 15:26 2019/4/13
 */
@RestController
@RequestMapping("/chain")
public class BlockController {

    @Autowired
    private IDBAccess dbAccess;
    @Autowired
    private BlockChain blockChain;
    @Autowired
    private Settings settings;


    @GetMapping({"", "/", "index"})
    public JsonVo index(HttpServletRequest request) {
        return JsonVo.success();
    }

    /**
     * 挖矿
     * @param request
     * @return
     */
    @GetMapping("/mine")
    public JsonVo mine(HttpServletRequest request) throws Exception {

        Block block = blockChain.mining();
        JsonVo vo = new JsonVo();
        vo.setCode(JsonVo.CODE_SUCCESS);
        vo.setMessage("Create a new block");
        vo.setItem(block);
        return vo;
    }

    /**
     * 浏览区块
     * @param request
     * @return
     */
    @GetMapping("/block/view")
    public JsonVo viewChain(HttpServletRequest request) {

        Optional<Block> block = dbAccess.getLastBlock();
        JsonVo success = JsonVo.success();
        if (block.isPresent()) {
            success.setItem(block.get());
        }
        return success;

    }

    /**
     * 发送交易
     * @param txVo
     * @return
     */
    @PostMapping("/transactions/new")
    public JsonVo sendTransaction(@RequestBody TransactionVo txVo) throws Exception {
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
        JsonVo success = JsonVo.success();
        success.setItem(transaction);
        return success;
    }

    /**
     * 添加节点
     * @param node
     * @return
     * @throws Exception
     */
    @PostMapping("/node/add")
    public JsonVo addNode(@RequestBody Map<String, Object> node) throws Exception {

        Preconditions.checkNotNull(node.get("ip"), "server ip is needed.");
        Preconditions.checkNotNull(node.get("port"), "server port is need.");

        blockChain.addNode(String.valueOf(node.get("ip")), (Integer) node.get("port"));
        return JsonVo.success();
    }

    /**
     * 查看节点列表
     * @param request
     * @return
     */
    @GetMapping("node/view")
    public JsonVo nodeList(HttpServletRequest request) {

        Optional<List<Node>> nodeList = dbAccess.getNodeList();
        JsonVo success = JsonVo.success();
        if (nodeList.isPresent()) {
            success.setItem(nodeList.get());
        }
        return success;
    }
}
