package com.ysu.spark._05_spark_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

/**
  *
  * created by bing57592
  * 2018-09-21 21:45
  */
// "/Users/bing57592/Documents/vedio/data"
case class People(name: String, salary: Int)

object HelloWorld extends App {
  // 创建spark对象
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HelloWorld")

  // 创建sparkSesslion
  val session = SparkSession.builder().config(sparkConf) // .enableHiveSupport() ==> 开启对Hive的支持
    .getOrCreate()
  val sc = session.sparkContext;

  import session.implicits._

  var people_DF = session.read.json("/Users/bing57592/Documents/vedio/data/employees.json") // 读取json文件, 返回一个DataFrame(一张表)
  people_DF.createOrReplaceTempView("people") // 给这个数据集附上一个名字
  session.sql("select name from people").show() // 在这里写出SQL语句
  println(people_DF.rdd.collect)
  people_DF.show() // 将json转换为一个表, 输出到控制台
  var people_RDD = sc.textFile("/Users/bing57592/Documents/vedio/data/employees.txt") // 读取一个txt文件, 转换为RDD
  people_RDD.map(item => {
    (item.split(", ")(0), item.split(", ")(1).toInt)
  }).toDF("name", "salary").show() // RDD转换为DataFrame
  println("------------------------------------------------------------")
  people_DF.rdd // 返回的是RDD[ROW]类型, 可以把这个Row中的方法理解为: 对json串的解析
  println("------------------------------------------------------------")
  val people_DS = people_RDD.map(item => {
    var par = item.split(", ")
    People(par(0), par(1).toInt)
  }).toDS() // 不知道为啥, 没抓出类型来 ==> 因为是懒执行, 没有看到show方法的时候, 不会执行这些代码
  people_DS.show()
  println("------------------------------------------------------------")
  people_DS.rdd // 返回的是RDD[Pepole] ==> 与DF相比, 在类型上有保证
  println("------------------------------------------------------------")
  people_DS.toDF() // DataSet ==> DataFrame
  println("------------------------------------------------------------")
  people_DF.as[People] // DataFrame => DataSet
  println("------------------------------------------------------------")
  var schema = StructType(StructField("name", StringType) :: StructField("salary", IntegerType) :: Nil)

  // 关闭sparkSession
  session.close()
  sc.stop()
}
