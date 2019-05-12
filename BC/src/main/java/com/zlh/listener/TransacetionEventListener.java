package com.zlh.listener;

import com.zlh.core.Transaction;
import com.zlh.event.SendTransactionEvent;
import com.zlh.net.base.MessagePacket;
import com.zlh.net.base.MessagePacketType;
import com.zlh.net.client.AppClient;
import com.zlh.utils.SerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhouLinHu
 * @Description:
 * @Date: Created in 21:09 2019/5/7
 */
@Component
public class TransacetionEventListener {
    @Autowired
    private AppClient appClient;

    /**
     * 向所有客户端广播交易
     * @param event
     */
    @EventListener(SendTransactionEvent.class)
    public void sendTransaction(SendTransactionEvent event) {

        Transaction transaction = (Transaction) event.getSource();
        MessagePacket messagePacket = new MessagePacket();
        messagePacket.setType(MessagePacketType.REQ_CONFIRM_TRANSACTION);
        messagePacket.setBody(SerializeUtils.serialize(transaction));
        appClient.sendGroup(messagePacket);
    }
}
