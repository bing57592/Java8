/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.service.impl;

import com.ysu.bean.User;
import com.ysu.service.UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈宪东 on 2018/10/24 17:17
 */
@Component
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> dataSourceMap = new HashMap<>();

    static {

        dataSourceMap.put(1, new User(1, "aa", 11, "12345"));
        dataSourceMap.put(2, new User(2, "vv", 13124, "12345"));
        dataSourceMap.put(3, new User(3, "df", 11, "12345"));
        dataSourceMap.put(4, new User(4, "sdfa", 124, "12345"));
        dataSourceMap.put(5, new User(5, "dfdsf", 11, "12345"));
    }

    @Override
    public User getUserById(Integer id) {
        return dataSourceMap.get(id);
    }
}
