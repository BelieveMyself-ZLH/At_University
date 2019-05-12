package com.zlh.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZhouLinHu
 * @Description: RocksDB配置参数，在配置文件中指明数据存储位置，有该类读取配置文件
 * @Date: Created in 16:12 2019/4/14
 */
@Configuration
@ConfigurationProperties(prefix = "rocksdb")
public class RocksDbProperties {
    private String dataDir;

    public String getDataDir() {
        return dataDir;
    }

    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }
}
