package com.ysu.java;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by bing57592
 * 2018-10-09 21:54
 */
public class StringTest {
    @Test
    public void test1() {
        String str = "   ";

        System.out.println(StringUtils.isEmpty(str.trim()));

        Map<String, Object> map = new HashMap<>();
        map.put("str", new Object());
        int h = 0 ;
        h = "str".hashCode();
        int i = (h = "str".hashCode()) ^ (h >>> 16);
        System.out.println(i);
    }

    @Test
    public void test2() throws Exception {
        List<String> list = new ArrayList<>();
    }
}
