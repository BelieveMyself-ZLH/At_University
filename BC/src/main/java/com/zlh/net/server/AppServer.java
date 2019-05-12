package com.zlh.net.server;

import com.zlh.net.conf.TioProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tio.server.AioServer;
import org.tio.server.ServerGroupContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: ZhouLinHu
 * @Description: 服务端启动程序
 * @Date: Created in 18:38 2019/5/7
 */
@Component
public class AppServer {
    @Resource
    private ServerGroupContext serverGroupContext;
    @Autowired
    private TioProperties properties;

    private static Logger logger = LoggerFactory.getLogger(AppServer.class);
    /**
     * 启动程序入口
     */
    @PostConstruct
    public void serverStart() throws IOException {
        logger.info("---------------服务端加载开始---------");
        AioServer aioServer = new AioServer(serverGroupContext);
        //本机启动服务
        aioServer.start(properties.getServerIp(), properties.getServerPort());
    }
}
