package com.dzq.study.redis;
/**
 * 描述:
 * 包名:com.dzq.study.redis
 * 版本信息: 版本1.0
 * 日期:2021/7/18
 * Copyright 三合力通
 */


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @describe：
 * @author: dengzq/三合力通
 * @version:v1.0
 * 2021/7/18 22:09
 */
public class RedissonTest {
    private static RedissonClient redisson;
    static {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // cluster state scan interval in milliseconds
                .addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001")
                .addNodeAddress("redis://127.0.0.1:7002");

        redisson = Redisson.create(config);
    }

    public static void main(String[] args) {
        RLock lock = redisson.getLock("anyLock");
        lock.lock();

    }
}
