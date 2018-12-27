package com.ysu.share

/** 小组内分享, 包含以下内容:
  * 一: SparkCore
  * [T] 常用算子
  * 1-val res =  rdd.map(item => (item , 1 ))
  * 2-val res =  rdd.filter(item => item._1.toInt % 2 == 0 )
  * 3-val res =  rdd1.union(rdd2)
  * 4-val res =  rdd1.intersection(rdd2)
  * 5-val res =  rdd1. distinct()
  * [K, V] 常用算子
  * 1.val res = rdd.reduceByKey( _ + _);
  * 2.val res = rdd.groupByKey()
  * 3.val res = rdd.mapValues( item._2.sort())
  *
  * 二: SparkSQL
  * 1. 读取生成一个DataFrame, DataFrame --> RDD
  * 2. 读取生成一个RDD,       RDD --> DataFrame
  * 3. 读取生成一个RDD,       RDD --> DataSet
  * 4. DataFrame <-> DataSet
  *
  * 三: SparkStreaming
  * 1. 启动一个SparkStreaming服务. 接收消息(看看就得了, windows上的 netcat 不好用)
  *
  * Created by 陈宪东 on 2018/12/27 0:08
  */
class Main {

}
