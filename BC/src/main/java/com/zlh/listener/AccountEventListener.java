package com.zlh.listener;

import com.zlh.account.Account;
import com.zlh.event.NewAccountEvent;
import com.zlh.net.base.MessagePacket;
import com.zlh.net.base.MessagePacketType;
import com.zlh.net.client.AppClient;
import com.zlh.utils.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhouLinHu
 * @Description: 账户事件监听器
 * @Date: Created in 21:06 2019/5/7
 */
@Component
public class AccountEventListener {
    private static Logger logger = LoggerFactory.getLogger(AccountEventListener.class);

    @Autowired
    private AppClient appClient;

    @EventListener(NewAccountEvent.class)
    public void newAccount(NewAccountEvent event) {

        Account account = (Account) event.getSource();
        logger.info("准备发起账户同步请求， {}", account);
        MessagePacket messagePacket = new MessagePacket();
        messagePacket.setType(MessagePacketType.REQ_NEW_ACCOUNT);
        messagePacket.setBody(SerializeUtils.serialize(account));
        appClient.sendGroup(messagePacket);
    }
}
