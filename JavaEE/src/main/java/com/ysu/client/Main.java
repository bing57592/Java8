package com.ysu.client;

import com.ysu.util.HttpClientUtils;
import com.ysu.util.TimeUtils;

/**
 * 这个类, 只是对服务器执行了请求.
 * created by bing57592
 * 2018-10-28 14:46
 */
public class Main {
    public static void main(String[] args) {
        String target = "http://localhost:8080/user/getUserInfo?username=sbyj";
        for (int i = 0; i < 100; i++) {
            System.out.print("第" + i + "次发送请求-\t");
            String resJson = HttpClientUtils.executeGetReq(target);
            TimeUtils.milSecondsArea(300);
            System.out.println(resJson);
        }
    }
}
