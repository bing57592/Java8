package com.ysu.unit1._01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author bing57592
 * @Date 2018-11-27 13:24
 */
@Controller
public class FunctionServiceUser {
    @Autowired
    FunctionService functionService;

    public void method1() {
        System.out.println(functionService);
    }
}
