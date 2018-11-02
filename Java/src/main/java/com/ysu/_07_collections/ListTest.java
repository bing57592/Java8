package com.ysu._07_collections;

import com.ysu._00_common.util.MyStringUtils;
import org.junit.Test;

import java.util.*;

/**
 * created by bing57592
 * 2018-10-28 19:49
 */
public class ListTest {
    @Test
    public void test() throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            list.add(i + "");
        }
        list.forEach(System.out::println);
        MyStringUtils.line();

        Collections.sort(list);
        list.forEach(System.out::println);

        Object o = new Object();

        Map<String, Object> map= new HashMap<>();
    }
}
