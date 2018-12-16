package com.ysu.spark._03_rdd_exercise

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * @Author bing57592 
  * @Date 2018-12-16 22:29
  */
object Answer_SQL {
	def main(args: Array[String]): Unit = {
		///Users/bing57592/Documents/code/Java8/Scala/src/main/resources/mysql-sql

		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
		var sc = new SparkContext(sparkConf)
		var rdd_exercise = sc.textFile("/Users/bing57592/Documents/code/Java8/Scala/src/main/resources/mysql-sql/exercise")
		var result = rdd_exercise.filter(item => {
			item.startsWith("--")
		}).collect()

		for (elem <- result) {
			println(elem)
		}

		sc.stop()
	}
}
