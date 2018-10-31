/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.controller;

import com.ysu.annotation.User;
import com.ysu.service.UserService;
import com.ysu.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈宪东 on 2018/10/24 15:31
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    final String formatSeconds = "EX"; // 表示秒
    final String formatMilliSeconds = "PX"; // 表示毫秒

    @ResponseBody
    @RequestMapping("/method1")
    public Object method1(@User String user) {
        return user;
    }

    @ResponseBody
    @RequestMapping("/method2/id")
    public Object method2(String user) {
        return user;
    }

    @ResponseBody
    @RequestMapping("/method3")
    public Object method3(String user) {
        return user;
    }

    @ResponseBody
    @RequestMapping("/method4")
    public Object method4(String user) {
        userService.insert();
        return user;
    }

    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> resultMap = new HashMap<>();
        Jedis jedis = RedisUtils.getJedis();
        String frequency = jedis.get(username);
        if (frequency == null) {
            jedis.set(username, "1", "NX", formatMilliSeconds, 2000);
            resultMap.put(username, 1);
        } else {
            int frequency_int = Integer.parseInt(frequency);
            if (frequency_int >= 4) { // 如果每5秒钟访问次数大于3
                resultMap.put("warning", "您的访问频率过高");
            } else {
                jedis.incrBy(username, 1);
                resultMap.put(username, frequency_int + 1);
            }
        }
        jedis.close();
        return resultMap;
    }
}
