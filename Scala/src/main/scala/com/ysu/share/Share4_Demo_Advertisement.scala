package com.ysu.share

import com.ysu.spark._03_rdd_exercise.Click
import org.apache.spark.{SparkConf, SparkContext}

/** /某个时间点 	   |某个省份   |某个城市   |某个用户    |某个广告
  * 1516609239711  5          3          70          27
  *
  * 需求：统计每一个省份点击TOP3的广告ID
  * 需求分析:
  *
  * 每个省份, 每个广告ID, 点击数量.(adid_pid, count)
  * 每个省份, List(每个广告ID, 点击数量)(pid, List(adid, count))
  * 1516609143867 6 7 64 16
  *
  * Created by 陈宪东 on 2018/12/27 2:29  
  */
object Share4_Demo_Advertisement extends App {
  var sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
  var sc = new SparkContext(sparkConf)
  // 1. 从textFile拿到的数据, 默认就是String类型的. 不用声明变量类型.
  var click = sc.textFile("C:\\Users\\chenxiandong\\Desktop\\input\\agent.log")
  val click2 = sc.textFile("hadoop78\\user\\plus\\input\\agent.log");
  // 这一步, 将日志中的数据集, 转换成Click对象的数据集.
  val rdd_click = click.map(item => {
    val param = item.split(" ")
    Click(param(0).toLong, param(1).toInt, param(2).toInt, param(3).toInt, param(4).toInt)
  })

  // 元数据 => (Click) => (省份_广告, 1)
  val rdd = click.map(item => {
    val param = item.split(" ")
    Click(param(0).toLong, param(1).toInt, param(2).toInt, param(3).toInt, param(4).toInt)
  }).map(item => {
    ((item.provinceId + "_" + item.adversementId), 1)
  })

  // (省份_广告, 1) => ((省份_广告), 数量) //每个省每条广告有多少点击量.
  val rdd_pidAAadid_count = rdd.reduceByKey(_ + _)


  // ((省份_广告), 数量) => (省份, (广告, 数量))
  val rdd_pid_adidAAcount = rdd_pidAAadid_count.map(item => {
    val params = item._1.split("_")
    (params(0), (params(1), item._2))
  })
  // (省份, (广告, 数量)) => (省份, Array(广告, 数量))
  val rdd_pid_adidAAcountArray = rdd_pid_adidAAcount.groupByKey()

  val result = rdd_pid_adidAAcountArray.mapValues(item => {
    item.toList.sortWith(_._2 > _._2).take(3)
  })
  sc.stop()
}
