package com.ysu.spark_streaming

import org.apache.spark._
import org.apache.spark.streaming._

/** 创建一个SparkStreaming
  *
  * @Author bing57592 
  * @Date 2018-12-22 21:59
  */
object Main extends App {
	// 创建和一个SparkConf 对象
	val sparkConf = new SparkConf().setAppName("streaming").setMaster("local[*]")
	val ssc = new StreamingContext(sparkConf, Seconds(5))
	// 可以通过ssc.sparkContext 来访问SparkContext
	// 或者通过已经存在的SparkContext来创建StreamingContext
	import org.apache.spark.streaming._
	val textDStream = ssc.socketTextStream("localhost", 9092) //DStream

	val wordsDStream = textDStream.flatMap(_.split(" "))
	val word2CountDStream = wordsDStream.map((_, 1))
	val result = word2CountDStream.reduceByKey(_ + _)
	result.print()


	ssc.start()
	ssc.awaitTermination()
}
