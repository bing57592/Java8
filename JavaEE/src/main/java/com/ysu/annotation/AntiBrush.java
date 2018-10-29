package com.ysu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 基于注解, 实现防刷功能.
 * Created by 陈宪东 on 2018/10/29 17:10
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AntiBrush {

    int milliseconds();

    int counts();
}
