package com.ysu.spark._05_spark_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.types._

/**
  *
  * created by bing57592     
  * 2018-09-21 20:16
  */
class MyAverage extends UserDefinedAggregateFunction { // 用户自定义聚合函数, 需要继承UserDefinedAggregateFunction
  //输入的类型
  override def inputSchema: StructType = StructType(StructField("input", LongType) :: Nil)

  //内部数据结构的类型
  override def bufferSchema: StructType = StructType(StructField("sum", LongType) :: StructField("count", LongType) :: Nil)

  //返回值的数据类型
  override def dataType: DataType = DoubleType

  //确定是否相同的输入会有相同的输出
  override def deterministic: Boolean = true

  //初始化内部数据结构
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0L
  }

  //更新你的内部数据结构
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    if (!input.isNullAt(0)) { // 如果新的数据, 不等于零(大概是这个意思,  这个if条件理解的不是特别贴切)
      buffer(0) = buffer.getLong(0) + input.getLong(0) // sum = sum + input
      buffer(1) = buffer.getLong(1) + 1 // count = count + 1
    }
  }

  //合并多个分区的数据结构
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0) // buffer1 和 buffer2 分别表示两个分区(的结果), 但是buffer2 是不能更改的.
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  //计算输出值
  override def evaluate(buffer: Row): Double = {
    buffer.getLong(0).toDouble / buffer.getLong(1)
  }
}

object MyAverage {

  def main(args: Array[String]): Unit = {

    //创建SparkConf对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("helloworld");
    //创建SparkSession
    val session = SparkSession.builder().config(sparkConf).getOrCreate() //一般在使用SparkSQL的时候要导入
    import session.implicits._

    val people_DF = session.read.json("/Users/bing57592/Documents/vedio/data/employees.json")

    people_DF.createOrReplaceTempView("people")

    //注册UDAF函数
    val myAverage = new MyAverage
    session.udf.register("myAverage", myAverage)

    session.udf.register("newFunction", (item: String) => item + "X") // 自定义函数

    session.sql("select myAverage(salary) from people").show()

    //关闭SparkSession
    session.close()

  }

}