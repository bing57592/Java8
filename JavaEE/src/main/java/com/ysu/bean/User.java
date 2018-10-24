package com.ysu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * created by bing57592
 * 2018-10-24 11:17
 */

@Data
@AllArgsConstructor
public class User {
    Integer id;
    String name;
    Integer age;
    String telephone;
}
