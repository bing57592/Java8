/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.resolver;

import com.ysu.bean.User;
import com.ysu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈宪东 on 2018/10/24 15:47
 */

public class UserResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;


    // 每个新的URL会访问此方法. 第二次访问时不会调用此方法
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        System.out.println(methodParameter);
        return methodParameter.hasParameterAnnotation(com.ysu.annotation.User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest nativeRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        Integer id = Integer.parseInt(nativeRequest.getParameter("id"));
        User userById = userService.getUserById(id);
        return userById.getName();
    }
}
