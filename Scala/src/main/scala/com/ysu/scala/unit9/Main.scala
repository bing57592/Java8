package com.ysu.scala.unit9

/**
  * 函数式编程高级
  *
  * @Author bing57592 
  * @Date 2018-12-12 17:02
  */
object Main {
    def main(args: Array[String]): Unit = {
        var res = (double: Double) => double * double
        println(res)
        println(res(56))

    }
}
