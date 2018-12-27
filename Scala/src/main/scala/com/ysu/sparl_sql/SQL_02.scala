package com.ysu.sparl_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  *
  * @Author bing57592 
  * @Date 2018-12-22 13:25
  */
object SQL_02 {

	case class Person(name: String, age: Int)

	def main(args: Array[String]): Unit = {
		//创建SparkConf对象
		val sparkConf = new SparkConf().setMaster("local[*]").setAppName("helloworld");
		val session = SparkSession.builder().config(sparkConf).getOrCreate()
		val sc = session.sparkContext

		import session.implicits._

		val rdd = sc.textFile("/Users/bing57592/Documents/SparkData/input/sparksql/people.txt")

		val ds = rdd.map(item => {
			val params = item.split(",")
			Person(params(0), params(1).trim.toInt)
		}).toDS()

		ds.show()

		//dataset => rdd 直接转换成 RDD[Person], 可以直接item.name, item.age
		val rdd2 = ds.rdd
		rdd2.map(item => {
			(item.name, item.age)
		})

		session.close()
	}
}