package com.ysu.scala.unit3

/**
  * 程序流程控制
  * scala的for循环和java的差异较大, 但是基本原理还是相同的.
  * scala的for循环是表达式, 是有返回值的. java的for循环不是表达式, 没有返回值.
  * scala的for循环的补偿是如何控制的? for(i <- Range(1, 1001, 2)) ==> 从1到100, 步长为2
  *
  * @Author bing57592 
  * @Date 2018-12-05 21:24
  */
object Loop1_for {
  def main(args: Array[String]): Unit = {
    // demo1
    // demo2

  }

  private def demo2 = {
    for (i <- 1 to 3) {
      print(i) //to: 前后闭合 [1, 3]  result: 1, 2, 3
    }
    println()
    for (i <- 1 until 3) {
      print(i) //until: 前闭后开 [1, 3)   result: 1, 2
    }
    println()
    for (i <- 1 to 3 if i != 2) {
      print(i) //if: 守卫 满足守卫的内容才会进入循环 result: 1, 3
    }
    println()
    for (i <- 1 to 3; j = 4 - i) {
      print(j) //j: 定义的变量. result: 3, 2, 1
    }
    println()

    //嵌套循环: 两者等价
    for (i <- 1 to 3; j <- 1 to 3) {
      println(i + "_" + j)
    }
    for (i <- 1 to 3) {
      for (j <- 1 to 3) {
        println(i + "_" + j)
      }
    }
    println()

    // yield关键字;  Vector(1, 2, 3, 4, 5) 将遍历结果中处理的结果返回给一个新的Vector集合中, 使用yield关键字
    var res = for (i <- 1 to 5) yield i
    println(res)
    println()

    for (i <- Range(1, 10, 2)) {
      println(i)
    }
    println()

    for (i <- 0 to 6; j = 6 - i) {
      println(i + " + " + j + " = " + (i + j))
    }
    println()
  }

  private def demo1 = {
    if (10 > 5) {
      println("10 > 5")
    } else {
      println("10 < 5")
    }
  }
}
