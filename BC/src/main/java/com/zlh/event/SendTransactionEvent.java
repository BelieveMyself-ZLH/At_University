package com.zlh.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: ZhouLinHu
 * @Description: 交易事件
 * @Date: Created in 21:21 2019/5/7
 */
public class SendTransactionEvent extends ApplicationEvent {
    public SendTransactionEvent(Object source) {
        super(source);
    }
}
