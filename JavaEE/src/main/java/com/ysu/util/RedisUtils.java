package com.ysu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * created by bing57592
 * 2018-10-27 16:45
 */
public class RedisUtils {
    private static JedisPool jedisPool = null;

    private static JedisPoolConfig jedisPoolConfig = null;

    static {
        jedisPoolConfig = new JedisPoolConfig();
        //指定连接池中最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        //链接池中创建的最大连接数
        jedisPoolConfig.setMaxTotal(5);
        //设置创建链接的超时时间
        jedisPoolConfig.setMaxWaitMillis(1000);
        //表示连接池在创建链接的时候会先测试一下链接是否可用，这样可以保证连接池中的链接都可用的。
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
    }


    //获取链接
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
