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

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
    val sc = new SparkContext(sparkConf)
    //		var rdd_exercise = sc.textFile("/Users/bing57592/Documents/code/Java8/Scala/src/main/resources/mysql-sql/")
    //		var result = rdd_exercise.filter(item => {
    //			item.startsWith("--")
    //		}).collect()
    //
    //		for (elem <- result) {
    //			println(elem)
    //		}
    val rdd_base = sc.textFile("C:\\Users\\chenxiandong\\Downloads\\catalina.out.2018-12-14-15_40_33.log-1545039813\\" +
      "export\\Instances\\plus.mobile\\server1\\logs\\catalina.out.2018-12-14-15_40_33.log")

    val rdd1 = rdd_base.filter(item => {
      item.contains("ERROR")
    })

    val res = rdd1.coalesce(1).saveAsTextFile("test/test.txt")

    sc.stop()
  }
}
