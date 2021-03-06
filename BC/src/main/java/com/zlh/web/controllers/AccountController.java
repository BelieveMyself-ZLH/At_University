package com.zlh.web.controllers;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.zlh.account.Account;
import com.zlh.account.Personal;
import com.zlh.crypto.ECKeyPair;
import com.zlh.crypto.Keys;
import com.zlh.db.IDBAccess;
import com.zlh.utils.JsonVo;
import com.zlh.web.vo.AccountVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhouLinHu
 * @Description: 账户操作控制器
 * @Date: Created in 14:47 2019/4/13
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private Personal personal;
    @Autowired
    private IDBAccess dbAccess;

    /**
     * 创建账户
     * @param request
     * @return
     */
    @PostMapping("/new")
    public JsonVo newAccount(HttpServletRequest request) throws Exception {

        ECKeyPair keyPair = Keys.createEcKeyPair();
        Account account = personal.newAccount(keyPair);
        AccountVo vo = new AccountVo();
        BeanUtils.copyProperties(account, vo);
        vo.setPrivateKey(keyPair.exportPrivateKey());
        return new JsonVo(JsonVo.CODE_SUCCESS, "New account created, please remember your Address and Private Key.",
                vo);
    }

    /**
     * 获取挖矿账号
     * @param request
     * @return
     */
    @GetMapping("/coinbase/get")
    public JsonVo coinbase(HttpServletRequest request) {

        Optional<Account> coinBaseAccount = dbAccess.getCoinBaseAccount();
        JsonVo success = JsonVo.success();
        if (coinBaseAccount.isPresent()) {
            success.setItem(coinBaseAccount.get());
        } else {
            success.setMessage("CoinBase Account is not created");
        }
        return success;
    }

    /**
     * 设置挖矿账号
     * @return
     */
    @PostMapping("/coinbase/set")
    public JsonVo setCoinbase(@RequestBody Map<String, String> params) {

        Preconditions.checkNotNull(params.get("address"), "address can not be null");
        dbAccess.putCoinBaseAddress(params.get("address"));
        return JsonVo.success();
    }

    /**
     * 列出所有的账号
     * @param request
     * @return
     */
    @GetMapping("/list")
    public JsonVo listAccounts(HttpServletRequest request) {

        List<Account> accounts = dbAccess.listAccounts();
        JsonVo success = JsonVo.success();
        success.setItem(accounts);
        return success;
    }
}
