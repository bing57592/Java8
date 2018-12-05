package com.ysu.scala.unit4

/**
  * 函数递归:
  * 函数递归需要遵循的重要原则:
  * 1. 执行一个函数时, 就创建一个新的受保护的独立空间(新函数栈/栈帧).
  * 2. 函数的局部变量是独立的, 不会互相影响.
  * 3. 递归必须向退出递归的条件逼近, 否则就是无限递归.
  * 4. 当一个函数执行完毕, 或者遇到return, 就会返回. 谁调用, 就将结果返回给谁. 同时当函数执行万一
  * ---或者返回的时候, 该函数栈本身也会被系统销毁.
  *
  * @Author bing57592 
  * @Date 2018-12-05 23:32
  */
object FunctionRecursion {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      println(i + ": " + exercise3(i))
    }
  }

  /**
    * 问题3: 猴子吃桃子问题.
    * 有一堆桃子, 猴子第一天吃了其中的一半, 并再多吃了一个. 以后猴子每天都吃其中的一半, 并再多吃一个
    * 当吃到第十天的时候, 发现只有一个桃子. 问最初由多少个桃子
    *
    *
    */
  def exercise3(n: Int): Int = {
    if (n == 1) return 1 else return 2 * (exercise3(n - 1) + 1)
  }

  /**
    * 问题2: 求函数值
    * 一直 f(1) = 3; f(n) = 2 * f ( n - 1 ) + 1
    */
  def exercise2(n: Int): Int = {
    if (n == 1) return 3 else return 2 * exercise2(n - 1) + 1
  }


  /**
    * 问题1: 请使用递归方式, 求出斐波那契数 1, 1, 2, 3, 5, 8...
    * 2018-12-05 23:46:26 做出来了
    */
  def exercise1(n: Int): Int = {
    if (n > 2) {
      return exercise1(n - 1) + exercise1(n - 2)
    } else {
      return 1;
    }
  }


  def demo2(n: Int) {
    if (n > 2) {
      demo2(n - 1)
    } else {
      println("n = " + n)
    }
  }

  //n = 2; n = 3; n = 4;
  def demo1(n: Int) {
    if (n > 2) {
      demo1(n - 1)
    }
    println("n = " + n)
  }
}