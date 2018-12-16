package com.ysu.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * @Author bing57592 
  * @Date 2018-12-14 02:13
  */
object Main {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
		var sc = new SparkContext(sparkConf)


		var list = Array(1, 2, 3, 4, 5)
		list.map(x => x + "a")
		//一: RDD的创建
		// 1. makeRDD:  -- param1: 集合; param2: 分片数
		var rdd1 = sc.makeRDD(Array(1, 2, 3, 4, 5))
		var rdd2 = sc.makeRDD(1 to 100, 10)
		var rdd3 = sc.parallelize(Array(1, 2, 3, 4), 10)
		var rdd4 = sc.makeRDD(Array("c n m", "d s b", "h r r"))

		var res1 = rdd2.mapPartitions(x => x.map(x => x + "a")).collect

		// 将rdd4中的数组中的每个元素, 按照 " " 切分, 然后压平. 与map相比, flatMap会压平.
		var result1 = rdd4.flatMap(_.split(" ")) //压平
		var result2 = rdd4.map(_.split(" ")) // 没压平, 数组中还是3个元素

		sc.stop()
	}
}
