package com.ysu.scala.unit2

/**
  *
  * @Author bing57592 
  * @Date 2018-12-04 23:21
  */
object DefDemo01 {
  def main(args: Array[String]): Unit = {
    var res = sayHello();
    println("res = " + res)
  }

  def sayHello(): Unit = {
    println("sayHello")
  }
}
