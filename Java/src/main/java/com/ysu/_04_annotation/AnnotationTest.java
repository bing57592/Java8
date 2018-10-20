package com.ysu._04_annotation;

import org.junit.Test;

/**
 * created by bing57592
 * 2018-10-21 01:08
 */

public class AnnotationTest {

    @MyAnnotation(value = "123")
    String field;

    @Test
    public void test1() throws Exception {
        System.out.println(field);
    }

}
