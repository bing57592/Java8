package com.ysu.spark._01_demo

import org.apache.spark._

/** local  local[*]  local[n]
  * spark://  standalone
  * mesos
  *
  * created by bing57592     
  * 2018-09-15 19:37 */
object WordCount extends App {
  //spark启动流程
  //1. 需要创建一个sparkConf对象, 并设置一些参数
  var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")

  //2. 根据sparkConf对象, 来创建sparkContext, 是一个与spark通信的连接
  var sc = new SparkContext(sparkConf)

  //3. 写业务逻辑
  // 3.1 获取文件流 ==> 通过dataFile.collect查看内容
  val rdd_source = sc.textFile("hdfs://hadoop102:9000/wordcount/input/wordcount.txt")

  // 3.2 分割字符串到字符
  val rdd_words = rdd_source.flatMap(_.split(" "))

  // 3.3 计数
  val rdd_words_count = rdd_words.map((_, 1))

  // 3.4 不知道在干什么((v, v) => v)
  val result = rdd_words_count.reduceByKey(_ + _)

  result.saveAsTextFile("hdfs://hadoop102:9000/wordcount/output")

  result.collect().foreach(println _)

  //4. 关闭与spark的通信
  sc.stop()
}