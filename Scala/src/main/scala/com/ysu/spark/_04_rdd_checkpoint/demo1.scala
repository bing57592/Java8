package com.ysu.spark._04_rdd_checkpoint

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 设置RDD的检查点
  * created by bing57592     
  * 2018-09-19 21:31
  */
object demo1 {
  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    var sc = new SparkContext(sparkConf)
    sc.setCheckpointDir("./checkpoint")


    var rdd_source = sc.textFile("/Users/bing57592/Documents/vedio/LocalData/agent.log")
  }
}
