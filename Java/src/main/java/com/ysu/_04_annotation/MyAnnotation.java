package com.ysu._04_annotation;

/**
 * created by bing57592
 * 2018-10-21 01:17
 */
public @interface MyAnnotation {
    String value() default "1234";
}
