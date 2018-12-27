package com.ysu.share

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 关于Rdd, DataFrame, DataSet之间的转换
  * Created by 陈宪东 on 2018/12/27 0:56  
  */
object Share2 extends App {
  var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
  var sc = new SparkContext(sparkConf)

  // 创建sparkSession
  val session = SparkSession.builder().config(sparkConf) // .enableHiveSupport() ==> 开启对Hive的支持
    .getOrCreate()

  //生成一个DataFrame
  var employees_DF = session.read.json("C:\\Users\\chenxiandong\\Desktop\\input\\employees.json") // 读取json文件, 返回一个DataFrame(一张表)
  //  session.read.csv("")
  //  session.read.jdbc("")
  employees_DF.createOrReplaceTempView("employees") // 给这个数据集附上一个名字
  session.sql("select * from employees").show() // 在这里写出SQL语句
  import session.implicits._

  //DataFrame => RDD
  val rdd1 = employees_DF.rdd
  // -------------------------------------------------------


  //生成一个RDD
  var rdd2 = sc.textFile("C:\\Users\\chenxiandong\\Desktop\\input\\people.txt")
  //RDD => DataFrame
  val people_DF = rdd2.map(item => {
    val params = item.split(", ")
    (params(0), (params(1)))
  }).toDF("name", "age")
  people_DF.createOrReplaceTempView("people")
  session.sql("select * from people").show()
  // -------------------------------------------------------

  //生成一个RDD(还用之前的RDD)
  var rdd3 = sc.textFile("C:\\Users\\chenxiandong\\Desktop\\input\\people.txt")

  //RDD => DataSet
  val people_DS = rdd3.map(item => {
    val params = item.split(", ")
    People(params(0), params(1).toInt)
  }).toDS()

  //这里会报错, DataSet不适用这种方式
  //  people_DS.createGlobalTempView("people_ds")
  //  session.sql("select * from people_ds").show()
  people_DS.show()
  //DataSet => Rdd
  val rdd4 = people_DS.rdd

  //DataSet => DataFrame
  val DF = people_DS.toDF()

  //DataFrame => DataSet
  val DS = people_DF.as[People]

  sc.stop()
}

case class People(name: String, salary: Int)