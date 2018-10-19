package com.ysu.scala.unit6

/**
  * 提取器, 恕我直言, 根本没看懂. 一点都没看懂.
  * unapply
  * 模式匹配, 本质上是, 调用元素的unapply方法.
  *
  * 如果返回一个some()集合, 说明返回成功.
  * 如果返回None, 则说明返回失败.
  * created by bing57592     
  * 2018-09-11 13:09
  */
object _6_6_ {
  //TODO: 提取器这块没看懂. 第二天第13个视频, 有必要再看一遍.
  def main(args: Array[String]): Unit = {
    val number: Double = 36.0
    number match {
      case Square(n) => println(s"square root of $number is $n")
      case _ => println("nothing matched")
    }

    println("----------------------------------------")

    var str = "Hadoop, Zookeeper, HBase"
    str match {
      case SquareSeq(str) => println(1)
      case _ => println("你去死吧")
    }

  }
}
