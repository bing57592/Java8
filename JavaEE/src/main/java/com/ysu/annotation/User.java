package com.ysu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 陈宪东 on 2018/10/24 15:45
 */


@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface User {
}
