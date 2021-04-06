package com.example.thymeleaf.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/4/6 10:35
 * @Description: Hbase 配置文件
 */
@ConfigurationProperties(prefix = "hbase")
public class HBaseProperties {

    private Map<String, String> config;

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
