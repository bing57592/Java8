package com.ysu.scala.unit7.highorder

/**
  * 折叠-flod
  * flod函数将上一步返回的值作为函数的第一个参数继续传递参与运算, 知道list中所有元素被遍历.
  * 1. 可以吧reduceLeft看做简化版的foldLeft.
  * --
  * 2. 相关函数: fold, foldLeft, foldRight, 可以参考reduce的相关放阿飞理解.
  *
  * @Author bing57592 
  * @Date 2018-12-08 21:36
  */
object FlodExercise {
  def main(args: Array[String]): Unit = {
    /**
      * foldLeft 和 foldRight 的缩写方法分别是: /: 和 :\
      *
      */
    var list2 = List(1, 9, 2, 8)

    /**
      * (0, 1, 9, 2, 8) ==> -20
      * 撇: 从左往右算
      *
      */
    val res1 = (0 /: list2) (_ - _)
    println(res1)


    /**
      * (1, 9, 2, 8, 10) ==> -4
      * 捺: 从右往左算
      */
    var res2 = (list2 :\ 10) (_ - _)
    println(res2)
  }

  private def method1 = {
    val list = List(1, 2, 3, 4)

    /** -5
      * 等同于(5, 1, 2, 3, 4)
      *
      * */
    var res1 = list.foldLeft(5)(minus)
    println(res1)

    /** 3
      * 等同于(1, 2, 3, 4, 5)
      *
      * */
    var res2 = list.foldRight(5)(minus)
    println(res2)
  }

  def minus(num1: Int, num2: Int): Int = {
    num1 - num2
  }

}
