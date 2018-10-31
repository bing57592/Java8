package com.ysu.utils;

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

    //用 sk:prodid:qt 表示一个产品的剩余个数(String存储).
    //用 sk:prod-id:usr 成功者的user_id(Set存储)
    public static boolean doSecKillByRedis(String userId, String productionId) {
        String qtKey = "sk:" + productionId + ":qt";
        String userSetKey = "sk:" + productionId + ":usr";
        Jedis jedis = getJedis();

        // 判断用户是否在userSet集合中
        if (jedis.sismember(userSetKey, userId)) {//如果userId已经存在在userSetKey中了的话
            jedis.close();
            System.err.println(userId + "已抢到");
            return false;
        }

        // 判断库存
        String stock = jedis.get(qtKey);
        if (stock == null) {// 判断库存信息是否为空
            jedis.close();
            System.err.println("库存信息未初始化");
            return false;
        } else {// 判断剩余库存, 如果小于0, 秒杀失败
            int count = Integer.parseInt(stock);
            if (count <= 0) {
                jedis.close();
                System.err.println("已售空");
                return false;
            }
        }
        jedis.decr(qtKey);
        jedis.sadd(userSetKey, userId);
        System.out.println(userId + "秒杀成功");
        jedis.close();
        return true;
    }
}
