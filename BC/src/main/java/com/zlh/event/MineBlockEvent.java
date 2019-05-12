package com.zlh.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: ZhouLinHu
 * @Description: 挖矿事件，当挖到一个新的区块时将触发
 * @Date: Created in 21:11 2019/5/7
 */
public class MineBlockEvent extends ApplicationEvent {
    public MineBlockEvent(Object source) {
        super(source);
    }
}
