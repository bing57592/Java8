package com.ysu.sparl_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * RDD 与 DataFrame的相互转换
  * @Author bing57592 
  * @Date 2018-12-22 12:30
  */
object SQL_01 {
	def main(args: Array[String]): Unit = {
		//创建SparkConf对象
		val sparkConf = new SparkConf().setMaster("local[*]").setAppName("helloworld");
		val session = SparkSession.builder().config(sparkConf).getOrCreate()
		val sc = session.sparkContext

		import session.implicits._

		val rdd = sc.textFile("/Users/bing57592/Documents/SparkData/input/sparksql/people.txt")


		// rdd => dataframes
		val rdd_to_dataFrame = rdd.map(item => {
			val params = item.split(",")
			(params(0), params(1).trim.toInt)
		}).toDF("name", "age")
		rdd_to_dataFrame.show()

		val dataFrame = rdd_to_dataFrame

		//dataFrame = > rdd  会转换成一个RDD[ROW]
		val dataFrame_to_rdd = dataFrame.rdd.map(item => {
			println(item.getAs("name"))
		})
		dataFrame_to_rdd.collect()

		//关闭SparkSession
		session.close()
	}
}
