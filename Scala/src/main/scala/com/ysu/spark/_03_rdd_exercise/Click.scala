package com.ysu.spark._03_rdd_exercise

/**
  * /某个时间点 	   |某个省份   |某个城市   |某个用户    |某个广告
  * created by bing57592     
  * 2018-09-20 19:06
  */
case class Click(time: Long, provinceId: Int, city: Int, userid: Int, adversementId: Int)
