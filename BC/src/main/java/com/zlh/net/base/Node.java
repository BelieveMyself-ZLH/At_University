package com.zlh.net.base;

import java.io.Serializable;

/**
 * @Author: ZhouLinHu
 * @Description: 定义节点
 * @Date: Created in 9:38 2019/4/15
 */
public class Node extends org.tio.core.Node implements Serializable {
    public Node(String ip, int port) {
        super(ip, port);
    }
    public Node(){
        super(null, 0);
    }
}
