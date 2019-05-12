package com.zlh.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: ZhouLinHu
 * @Description: 发起同步请求下一个区块时触发
 * @Date: Created in 21:11 2019/5/7
 */
public class FetchNextBlockEvent extends ApplicationEvent {
    public FetchNextBlockEvent(Object source) {
        super(source);
    }
}
