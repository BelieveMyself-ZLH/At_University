package com.zlh.account;

import com.google.common.base.Optional;
import com.zlh.crypto.ECKeyPair;
import com.zlh.db.IDBAccess;
import com.zlh.event.NewAccountEvent;
import com.zlh.net.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author: ZhouLinHu
 * @Description: 账户操作
 * @Date: Created in 17:27 2019/5/7
 */
@Component
public class Personal {
    @Autowired
    private IDBAccess idbAccess;

    public Account newAccount(ECKeyPair keyPair) throws Exception{
        Account account=new Account(keyPair.getAddress(), BigDecimal.ZERO);
        //存储账户
        idbAccess.putAccount(account);
        //发布同步账号事件
        ApplicationContextProvider.publishEvent(new NewAccountEvent(account));
        //如果没有发现挖矿账号, 则优先创建挖矿账号
        Optional<Account> coinBaseAccount = idbAccess.getCoinBaseAccount();
        if (!coinBaseAccount.isPresent()) {
            idbAccess.putCoinBaseAccount(account);
        }
        return account;
    }
}
