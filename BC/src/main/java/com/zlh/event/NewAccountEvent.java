package com.zlh.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: ZhouLinHu
 * @Description: 创建账户事件
 * @Date: Created in 21:20 2019/5/7
 */
public class NewAccountEvent extends ApplicationEvent {
    public NewAccountEvent(Object source) {
        super(source);
    }
}
