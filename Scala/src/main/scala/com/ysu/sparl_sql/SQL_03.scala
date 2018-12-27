package com.ysu.sparl_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  *
  * @Author bing57592 
  * @Date 2018-12-22 13:45
  */
object SQL_03 {

	case class Person(name: String, age: Int)

	def main(args: Array[String]): Unit = {
//		//创建SparkConf对象
//		val sparkConf = new SparkConf().setMaster("local[*]").setAppName("helloworld");
//		val session = SparkSession.builder().config(sparkConf).getOrCreate()
//		val sc = session.sparkContext
//
//		import session.implicits._
//
//		val rdd = sc.textFile("/Users/bing57592/Documents/SparkData/input/sparksql/people.txt")
//
//		val ds = rdd.toDS()
//		val df = ds.toDF()
//
//		session.close()
	}
}
