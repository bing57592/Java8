package com.ysu.scala.unit7.tuple

/**
  * 元组-Tuple的基本使用
  * 元组也可以理解为一个容器, 可以存放各种相同或不同数据类型的数据.
  * 说的简单点, 就是讲多个无关的数据封装为一个整体, 称为元组
  * 注意: 元祖中最大只能有22个元素, 类型可以不同.
  *
  * @Author bing57592 
  * @Date 2018-12-08 02:25
  */
object Main {
  def main(args: Array[String]): Unit = {
    // 创建一个元组, 类型是Tuple4.
    // 获取元组中元素的方式是: tuple._1; tuple._2
    val tuple = (1, 2, 3, "hello", 5)
    val element = tuple.productElement(5)
    for (i <- tuple.productIterator) println(i)
    for (elem <- tuple.productIterator) {
      println(elem)
    }

  }
}
