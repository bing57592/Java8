//package com.ysu.spark._05_spark_sql
//
//
//import org.apache.spark.SparkConf
//import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession}
//import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
//
//case class Employee(name: String, salary: Long)
//
//case class Average(var sum: Long, var count: Long)
//
//class MyAverage2 extends Aggregator[Employee, Average, Double] {// 与 "弱类型用户自定义聚合函数" 相比, 这里通过[C, V, T] 限定类型
//
//  //初始化一个数据结构
//  override def zero: Average = Average(0L, 0L)
//
//  //聚合相同分区中的结果
//  override def reduce(b: Average, a: Employee): Average = {
//    b.sum += a.salary
//    b.count += 1
//    b
//  }
//
//  //聚合不同分区中的结果
//  override def merge(b1: Average, b2: Average): Average = {
//    b1.sum += b2.sum
//    b1.count += b2.count
//    b1
//  }
//
//  //计算输出
//  override def finish(reduction: Average): Double = {
//    reduction.sum.toDouble / reduction.count
//  }
//
//  //设置中间值类型的编码器 ==> 将共享的数据进行编码
//  override def bufferEncoder: Encoder[Average] = Encoders.product
//
//  //设置输出值类型的编码器 ==> 将输出进行编码
//  override def outputEncoder: Encoder[Double] = Encoders.scalaDouble
//}
//
//object MyAverage2 {
//
//  def main(args: Array[String]): Unit = {
//
//    //创建SparkConf对象
//    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("helloworld");
//    //创建SparkSession
//    val session = SparkSession.builder().config(sparkConf).getOrCreate() //一般在使用SparkSQL的时候要导入
//    import session.implicits._
//    val people_DF = session.read.json("/Users/bing57592/Documents/vedio/data/employees.json")
//    //注册UDAF函数
//    val myAverage = new MyAverage2().toColumn.name("average")
//
//    people_DF.select(myAverage).show() //关闭SparkSession
//    session.close()
//
//  }
//
//}