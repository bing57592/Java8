package com.ysu.spark._06_spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming._

/**
  *
  * created by bing57592     
  * 2018-09-24 09:23
  */
object Streaming extends App {
  //创建一个SParkConf对象
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")

  //通过SparkConf对象创建一个StreamingContext
  val ssc = new StreamingContext(sparkConf, Seconds(5)) // 每五秒, 生成一个rdd
  val sc = ssc.sparkContext

  // 获得数据
  val textDStream = ssc.socketTextStream("hadoop102", 9999) // 监控hadoop102机器上的 9999 端口, 发送的数据.
  //DStream[String]
  val wordsDStream = textDStream.flatMap(_.split(" "))
  //DStream[(String,Int)]
  val word2CountDStream = wordsDStream.map((_, 1))
  //DStream[(String,Int)]
  val result = word2CountDStream.reduceByKey(_ + _)

  result.print()

  ssc.start() // 启动程序
  ssc.awaitTermination() // 当程序非法结束的时候, 会抛出异常
}
