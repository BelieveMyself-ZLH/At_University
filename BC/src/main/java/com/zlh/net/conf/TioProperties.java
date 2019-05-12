package com.zlh.net.conf;

import com.zlh.net.base.Node;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: ZhouLinHu
 * @Description: tio网络架构配置信息
 * @Date: Created in 17:37 2019/5/7
 */
@Configuration
@ConfigurationProperties(prefix = "tio")
public class TioProperties {
    /**
     * 心跳包时间间隔
     */
    @NotNull
    private int heartTimeout;
    /**
     * 客户端分组名称
     */
    @NotNull
    private String clientGroupName;
    /**
     * 服务端分组上下文名称
     */
    @NotNull
    private String serverGroupContextName;
    /**
     * 服务端监听端口
     */
    @NotNull
    private int serverPort;
    /**
     * 服务端绑定的 ip
     */
    private String serverIp;

    private List<Node> nodes;

    public int getHeartTimeout() {
        return heartTimeout;
    }

    public void setHeartTimeout(int heartTimeout) {
        this.heartTimeout = heartTimeout;
    }

    public String getClientGroupName() {
        return clientGroupName;
    }

    public void setClientGroupName(String clientGroupName) {
        this.clientGroupName = clientGroupName;
    }

    public String getServerGroupContextName() {
        return serverGroupContextName;
    }

    public void setServerGroupContextName(String serverGroupContextName) {
        this.serverGroupContextName = serverGroupContextName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
