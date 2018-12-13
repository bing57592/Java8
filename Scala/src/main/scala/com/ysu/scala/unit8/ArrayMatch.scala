package com.ysu.scala.unit8

/**
  * 匹配数组
  * 基本介绍:
  * 1. Array(0) 匹配只有一个数组元素且为0的数组
  * 2. Array(x, y) 匹配数组有两个元素, 并将两个元素赋值为 x 和 y. 当然可以依次类推...
  * 3. Array(0, _*) 匹配数组一0开始.
  *
  * @Author bing57592 
  * @Date 2018-12-11 01:14
  */
object ArrayMatch {
    def main(args: Array[String]): Unit = {
        for (list <- Array(List(0), List(88), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
            val result = list match {
                case 0 :: Nil => "0" //
                case x :: y :: Nil => x + " " + y //
                case 0 :: tail => "0 ..." //
                case x => x
                case _ => "something else"
            }
            println(result)
        }

    }

    private def method1 = {
        for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))) {
            val result = arr match {
                case Array(0) => "0"
                case Array(x, y) => x + "=" + y
                case Array(0, _*) => "以0开头和数组"
                case _ => "什么集合都不是"
            }
            println("result = " + result)
        }
    }
}
