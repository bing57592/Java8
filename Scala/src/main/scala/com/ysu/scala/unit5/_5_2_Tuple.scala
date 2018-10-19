package com.ysu.scala.unit5

/**
  *
  * created by bing57592     
  * 2018-09-10 00:41
  */
object _5_2_Tuple {
  def main(args: Array[String]): Unit = {
    //元祖Tunple设计出来是为了存放(临时)数据的. 不可更新, 不可删除
    var t1 = Tuple1("hello") // 强制一个参数
    var t2 = Tuple2("肥宅快乐水", 3) // 强制两个参数
    var t3 = Tuple3("肥宅快乐水", 3, "Wow") // 强制三个参数
    println("----------------------------------------")

    //遍历元祖
    for (x <- t2.productIterator) {
      println(x)
    }
    t2.productIterator.foreach(println(_))
    println("----------------------------------------")
    println(t3._3)
  }
}
