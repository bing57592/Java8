package com.ysu.spark._02_rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * @Author bing57592 
  * @Date 2018-12-15 13:21
  */
object Main2 {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
		var sc = new SparkContext(sparkConf)

		var rdd = sc.makeRDD(Array(Score("a", 50), Score("b", 50), Score("c", 30), Score("b", 70),
			Score("a", 90), Score("c", 90), Score("c", 10), Score("c", 20), Score("a", 70)))

		sc.stop()
	}

}
