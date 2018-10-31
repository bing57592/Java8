package com.ysu.controller;

import com.ysu.utils.MathUtils;
import com.ysu.utils.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by bing57592
 * 2018-11-01 00:30
 */
@Controller
public class SecSkillController {

    AtomicInteger aInt = new AtomicInteger(0);

    @ResponseBody
    @RequestMapping("/secSkill")
    public Object secSkill(String prodId, String name) {
        String userId = MathUtils.random(10000) + "";
        boolean result = RedisUtils.doSecKillByRedis(userId, "1010");
        if (result) aInt.incrementAndGet();
        return result;
    }

    @ResponseBody
    @RequestMapping("/result")
    public Object result() {
        return aInt;
    }

    @ResponseBody
    @RequestMapping("/init/{stock}")
    public Object init(@PathVariable("stock") int stock) {
        aInt = new AtomicInteger(0);
        Jedis jedis = RedisUtils.getJedis();
        jedis.del("sk:1010:usr");
        jedis.set("sk:1010:qt", stock + "");
        jedis.close();
        return "aInt is 0 now ";
    }
}
