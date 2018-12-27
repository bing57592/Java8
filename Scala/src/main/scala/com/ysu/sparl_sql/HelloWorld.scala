package com.ysu.sparl_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  *
  * @Author bing57592 
  * @Date 2018-12-22 12:31
  */
object HelloWorld {
	def main(args: Array[String]): Unit = {
		//创建SparkConf对象
		val sparkConf = new SparkConf().setMaster("local[*]").setAppName("helloworld");

		//创建SparkSession
		val session = SparkSession.builder().config(sparkConf)
				//.enableHiveSupport()
				.getOrCreate()
		val sc = session.sparkContext

		//一般在使用SparkSQL的时候要导入
		import session.implicits._

		// 读取json文件. 相应的还有csv, jdbc 等等格式
		val people = session.read.json("/Users/bing57592/Documents/SparkData/input/sparksql/employees.json")

		// 将people这个DataFrame, 声明为一张表, 表名如下, (不能使用中文)
		people.createOrReplaceTempView("emp")

		session.sql("select name from emp").show()

		println(people.rdd.collect())

		people.show()

		//关闭SparkSession
		session.close()

	}
}
