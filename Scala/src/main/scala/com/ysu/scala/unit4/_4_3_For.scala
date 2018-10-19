package com.ysu.scala.unit4

/**
  *
  * created by bing57592     
  * 2018-09-09 22:15
  */
object _4_3_For {
  def main(args: Array[String]): Unit = {

    println("----------------------------------------") //for1
    for (i <- 1 to 10) {
      println(i)
    }
    println("----------------------------------------") //for2
    //    for (i <- 1 to 10; j <- 1 to 10) {
    //      println((i * j))
    //    }
    println("----------------------------------------") //for3
    for (i <- 1 to 10 if i != 4) {
      //** j != 4 称谓守卫
      println(i)
    }
    println("----------------------------------------") //for4
    for (i <- 1 to 10; j = i + 1) {
      println(i + "_" + j)
    }
    println("----------------------------------------") //for5
    var result = for (i <- 1 to 10) yield (i * 3 + 2) // 产生一个向量, 对每个参数做yield操作.
    println(result)
    println("----------------------------------------") //exercise1
    exercise1(5)
    println("----------------------------------------") //exercise2
    var array = Array(18, 19, 20, 33, 55)
    array.foreach(println(_))
    array.foreach(x => {// 这TM和lambda表达式有什么区别么.
      for (i <- 2 to x) {
        //判断是否为质数. 真TM懒得写
      }
    })
  }

  /**
    * 练习一: 使用for循环, 打印正方形.
    * 练习二: 遍历某个年龄集合, 打印其中的质数年龄.
    *
    * @return
    */
  def exercise1(length: Int) = {
    for (i <- 1 to length) {
      for (j <- 1 to length) {
        printf("*")
      }
      println()
    }
  }

}

