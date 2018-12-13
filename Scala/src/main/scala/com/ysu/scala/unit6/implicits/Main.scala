package com.ysu.scala.unit6.implicits

/**
  * 隐式转换和隐饰函数
  * 隐饰函数基本介绍: 银时转换函数是以 implicit 关键字声明的带有单个参数的函数. 这种函数将会自动应用
  * 将值从一种类型转换为另一种类型
  *
  * @Author bing57592 
  * @Date 2018-12-06 23:38
  */
object Main {
  def main(args: Array[String]): Unit = {
    implicit val name1: String = "name1"

    def method(implicit name1: String = "Jack"): Unit = {
      println(name1)
    }

    method
  }


  /**
    * 定义这样一个函数, 相当于在底层生成了Main.f1;
    * 当运行时, 发现满足
    *
    * @param d
    * @return
    */
  implicit def f1(d: Double): Int = {
    d.toInt
  }

  implicit def f3(d: Double): String = {
    d + ""
  }

  implicit def f2(d: Double, string: String): Unit = {
    println("f2")
  }

  var v1: Int = (3.5)
}
