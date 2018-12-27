package com.ysu.share

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by 陈宪东 on 2018/12/27 1:41  
  */
object Share3_SparkStreaming extends App {
  //创建一个SParkConf对象
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")

  //通过SparkConf对象创建一个StreamingContext
  val ssc = new StreamingContext(sparkConf, Seconds(5)) // 每五秒, 生成一个rdd
  val sc = ssc.sparkContext

  // 获得数据
  val textDStream = ssc.socketTextStream("localhost", 9999) // 监控localhost机器上的 9999 端口, 发送的数据.
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
