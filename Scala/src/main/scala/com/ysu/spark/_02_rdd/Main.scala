package com.ysu.spark._02_rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * RDD: 弹性分布式数据集, Spark计算的基石, 为用户屏蔽了底层对数据的复杂抽象和处理, 为用户提供了一组
  * 方便的数据转换和求值的方法
  *
  * @Author bing57592 
  * @Date 2018-12-14 02:08
  */
object Main {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
		var sc = new SparkContext(sparkConf)
		//一: RDD的创建
		// 1. makeRDD:  -- param1: 集合; param2: 分片数
		var rdd1 = sc.makeRDD(Array("Bob", "Bob", "Sum", "Sum", "Tony"))
		// println(rdd1.map(x => (x, x)).groupByKey.collect.mkString(", "))
		var rdd8 = sc.makeRDD(Array(("a", 50), ("b", 50), ("c", 30), ("b", 70),
			("a", 90), ("c", 90), ("c", 10), ("c", 20), ("a", 70)))

		val res = rdd8.combineByKey(
			(_, 1),
			(c0: (Int, Int), v) => (c0._1 + v, c0._2 + 1),
			(c1: (Int, Int), c2: (Int, Int)) => (c1._1 + c2._1, c1._2 + c2._2))
				.map(item => (item._1, item._2._1 / item._2._2))


		sc.stop()
	}
}

case class Score(name: String, score: Int)