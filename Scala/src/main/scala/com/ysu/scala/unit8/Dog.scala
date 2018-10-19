package com.ysu.scala.unit8

import scala.beans.BeanProperty

/**
  *
  * created by bing57592     
  * 2018-09-12 23:07
  */
class Dog {
  var leg = 5;

  @BeanProperty var eye = 2;//加上这个注解之后, 会自动创建Java版本的get, set 方法

}
