package com.ysu.scala.unit3

/**
  * @Author bing57592
  * @Date 2018-12-05 20:58
  */
object Main {
  def main(args: Array[String]): Unit = {
    //  demo1();
    //  demo2();
    //  demo3();
    println("请输入姓名")

  }

  def demo3(): Unit = {
    var a = 1
    var b = 2
    a = a + b
    b = a - b
    a = a - b
    println(a)
  }

  /**
    * <<=: 右移后赋值
    * >>=: 左移后赋值
    * &=: 换位与后赋值   c &= 2 等效于  c = c & 2
    * |=: 换位或后赋值   c |= 2 等效于  c = c | 2
    * 二进制相关内容
    */
  def demo2(): Unit = {
    var c = 1234567
    c <<= 2;
    println(c)

    c >>= 2;
    println(c)
  }

  /**
    * 赋值运算符:
    * +=: 相加后赋值.
    * -=: 相减后赋值
    * *=: 相乘后赋值
    * /=: 相除后赋值
    */
  def demo1(): Unit = {
    var a: Int = 10;
    var b: Int = 2;
    a += 2
    println(a)
    a -= 2
    println(a)
    a *= 2
    println(a)
    a /= 2
    println(a)

  }


}
