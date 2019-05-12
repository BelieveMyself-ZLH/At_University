package com.zlh.net.client;

import com.google.common.base.Optional;
import com.zlh.conf.Settings;
import com.zlh.db.IDBAccess;
import com.zlh.event.FetchNextBlockEvent;
import com.zlh.net.ApplicationContextProvider;
import com.zlh.net.base.MessagePacket;
import com.zlh.net.base.MessagePacketType;
import com.zlh.net.base.Node;
import com.zlh.net.conf.TioProperties;
import com.zlh.utils.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.tio.client.AioClient;
import org.tio.client.ClientChannelContext;
import org.tio.client.ClientGroupContext;
import org.tio.core.Aio;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhouLinHu
 * @Description: 客户端启动程序
 * @Date: Created in 18:21 2019/5/7
 */
@Component
public class AppClient {
    @Resource
    private ClientGroupContext clientGroupContext;
    @Autowired
    private TioProperties tioProperties;

    private AioClient aioClient;
    @Autowired
    private IDBAccess dbAccess;
    @Autowired
    Settings settings;

    private static Logger logger = LoggerFactory.getLogger(AppClient.class);

    /**
     * 启动程序入口
     */
    @PostConstruct
    public void clientStart() throws Exception {
        logger.info("---------------客户端程序加载启动-----------");
        if (!settings.isNodeDiscover()) {
            return;
        }

        aioClient = new AioClient(clientGroupContext);
        //加载数据库中的节点数据
        Optional<List<Node>> nodeList = dbAccess.getNodeList();
        List<Node> nodes = null;
        if (nodeList.isPresent()) {
            nodes = nodeList.get();

            //初始化配置 properties 中的节点
        } else if (null != tioProperties.getNodes()) {
            nodes = tioProperties.getNodes();
        }
        // 添加节点
        for (Node node : nodes) {
            addNode(node.getIp(), node.getPort());
        }
    }

    /**
     * 发送消息到一个group
     * @param messagePacket
     */
    public void sendGroup(MessagePacket messagePacket) {

        if (!settings.isNodeDiscover()) {
            return;
        }

        Aio.sendToGroup(clientGroupContext, tioProperties.getClientGroupName(), messagePacket);
    }

    /**
     * 添加节点
     * @param serverIp
     * @param port
     */
    public void addNode(String serverIp, int port) throws Exception {

        if (!settings.isNodeDiscover()) {
            return;
        }

        Node node = new Node(serverIp, port);
        ClientChannelContext channelContext = aioClient.connect(node);
        Aio.send(channelContext, new MessagePacket(SerializeUtils.serialize(MessagePacket.HELLO_MESSAGE)));
        Aio.bindGroup(channelContext, tioProperties.getClientGroupName());
        dbAccess.addNode(node);
        logger.info("添加节点成功, {}", node);
    }

    /**
     * 启动的时候自动开始区块同步
     */
    @EventListener(ApplicationReadyEvent.class)
    public void fetchNextBlock() {
        ApplicationContextProvider.publishEvent(new FetchNextBlockEvent(0));

    }

    /**
     * 同步账户列表
     */
    @EventListener(ApplicationReadyEvent.class)
    public void fetchAccounts() {

        MessagePacket packet = new MessagePacket();
        packet.setType(MessagePacketType.REQ_ACCOUNTS_LIST);
        packet.setBody(SerializeUtils.serialize(MessagePacket.FETCH_ACCOUNT_LIST_SYMBOL));
        sendGroup(packet);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fetchNodeList() {

        logger.info("++++++++++++++++++++++++++ 开始获取在线节点 +++++++++++++++++++++++++++");
        MessagePacket packet = new MessagePacket();
        packet.setType(MessagePacketType.REQ_NODE_LIST);
        packet.setBody(SerializeUtils.serialize(MessagePacket.FETCH_NODE_LIST_SYMBOL));
        sendGroup(packet);
    }
}
