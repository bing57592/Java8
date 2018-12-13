package com.ysu.scala.unit7.highorder

/**
  * 化简: 将二元函数引用于集合中的函数
  * 需求: 求出val list = List(1, 20, 30, 4, 5), 求出list 的和
  * [译] reduce: 归纳为
  *
  * @Author bing57592 
  * @Date 2018-12-08 20:35
  */
object ReduceExercise {
  def main(args: Array[String]): Unit = {
    /**
      * 用化简的方式, 求出List(3, 4, 2, 7, 5)的最小值
      */
    var list = List(3, 4, 2, 7, 5)
    var res1 = list.reduceLeft((a, b) => a min b)
    var res2 = list.reduceLeft(_ min _) // res1 等同于 res2
    println(res1)
    println(res2)
  }

  private def method1 = {
    /**
      * list1.reduceLeft((a, b) => (a - b))
      * (1, 20, 30, 4, 5)
      * (-19, 30, 4, 5)
      * (-49, 4, 5)
      * (-53, 5)
      * (-58)
      */
    val list1 = List(1, 20, 30, 4, 5)
    var res1 = list1.reduceLeft((a, b) => a - b)
    println(res1)

    /**
      * (1, 20, 30, 4, 5)
      * (1, 20, 30, -1)
      * (1, 20, 31)
      * (1, -11)
      * (12)
      */
    var list2 = list1
    var res2 = list2.reduceRight((a, b) => a - b)
    println(res2)

    // -13
    var list3 = List(1, 2, 3, 4, 5)
    var res3 = list3.reduceLeft((a, b) => a - b)
    println(res3)

    // 3
    var list4 = List(1, 2, 3, 4, 5)
    var res4 = list4.reduceRight((a, b) => a - b)
    println(res4)
  }
}
