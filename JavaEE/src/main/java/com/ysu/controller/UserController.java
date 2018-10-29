/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.controller;

import com.ysu.annotation.AntiBrush;
import com.ysu.annotation.User;
import com.ysu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 陈宪东 on 2018/10/24 15:31
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


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
    @AntiBrush(milliseconds = 555, counts = 123)
    @RequestMapping("/method3")
    public Object method3(String user) {
        return user;
    }


    @ResponseBody
    @AntiBrush(milliseconds = 123, counts = 1)
    @RequestMapping("/method4")
    public Object method4(String user) {
        userService.insert();
        com.ysu.bean.User userBean = new com.ysu.bean.User();
        userBean.setAge(123);
        userBean.setId(4567489);
        userBean.setName("微信");
        userBean.setTelephone("52");
        return userBean;
    }
}
