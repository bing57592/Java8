package com.ysu.spark._06_spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
  *
  * created by bing57592     
  * 2018-09-24 14:46
  */
object QueueRDD {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")

    //通过SparkConf对象创建一个StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(1))


    // 创建RDD队列
    var rddQueue = new mutable.SynchronizedQueue[RDD[Int]]
    var inputStream = ssc.queueStream(rddQueue)

    // 处理队列中的RDD数据
    var mappedStream = inputStream.map(x => (x % 10, 1))
    var reducedStream = mappedStream.reduceByKey(_ + _)

    reducedStream.print()

    ssc.start()

    for (i <- 1 to 30) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 300, 10)
      Thread.sleep(2000)
    }
    ssc.awaitTermination()
  }
}
