package com.ysu._03_reflect.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * created by bing57592
 * 2018-10-21 01:47
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();
}
