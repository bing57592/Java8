package com.ysu.scala.unit7.highorder

/**
  * 1. map映射函数
  * 2. flatMap映射函数
  *
  * @Author bing57592 
  * @Date 2018-12-08 19:31
  */
object Main {
  def main(args: Array[String]): Unit = {
    // test1(function, 2.5)
    // test2(myPrint)
    // test3(sayHello, "Hello World")
    val names = List("Alice", "Bob", "Nick")
  }

  def mul(n: Int): Int = {
    n * 2
  }

  /**
    * 1. test函数可以接收一个函数, test是高阶函数. ==> 高阶函数的特点: 可以接收一个函数
    * 2. f: Double => Double, 代表一个函数. 这个函数的入参是Double的, 出参是Double的
    *
    * @param f
    * @param n1
    * @return
    */
  def test1(f: Double => Double, n1: Double) = {
    f(n1)
  }


  def function(n: Double): Double = {
    n * n + 2
  }

  def test2(f: () => Unit): Unit = {
    f()
  }

  def myPrint(): Unit = {
    println("Hello World")
  }

  // -----------
  def test3(f: String => Unit, str: String): Unit = {
    f(str)
  }

  def sayHello(str: String): Unit = {
    println(str)
  }
}
